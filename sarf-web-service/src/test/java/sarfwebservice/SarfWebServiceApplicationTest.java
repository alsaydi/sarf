package sarfwebservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import sarfwebservice.controllers.SarfController;
import sarfwebservice.models.RootResult;
import sarfwebservice.models.VerbConjugations;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SarfWebServiceApplicationTest {

	@LocalServerPort
	private int port;

	@Autowired
	private SarfController sarfController;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void contextLoads() {
		assertThat(sarfController).isNotNull();
	}

	@Test
	public void nonExistingRootReturns404() {
		var responseEntity = this.testRestTemplate.getForEntity("/sarf/تتت", Object.class);
		assertThat(responseEntity).isNotNull();
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}

	private static List<String> getRoots() {
		return List.of("قرء", "زلزل", "سلم", "ءمر", "روض");
	}

	@ParameterizedTest()
	@MethodSource("getRoots")
	public void validRootReturnsResult(String root) {
		List<RootResult> result = new ArrayList<>();
		var responseEntity = this.testRestTemplate.getForEntity("/sarf/" + root, result.getClass());
		assertThat(responseEntity).isNotNull();
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		result = responseEntity.getBody();
		assertThat(result.isEmpty()).isFalse();
		assertThat(result.size()).isEqualTo(1);
		LinkedHashMap linkedHashMap = (LinkedHashMap) responseEntity.getBody().get(0);
		assertThat(linkedHashMap).isNotNull();
		assertThat(linkedHashMap.size()).isEqualTo(5);
		assertThat(linkedHashMap.get("root")).isEqualTo(root);
		assertThat(linkedHashMap.get("unaugmentedRoots")).isNotNull();
		assertThat(linkedHashMap.get("conjugationResults")).isNotNull();
	}

	@ParameterizedTest()
	@MethodSource("getRootsForActiveTest")
	public void getVerbs(String type, String root, boolean augmented, int cclass, int formula) {
		List<VerbConjugations> result = new ArrayList<>();
		var responseEntity = this.testRestTemplate.getForEntity(
				String.format("/sarf/%s/%s?augmented=%s&cclass=%d&formula=%d",type,root, augmented,cclass,formula) ,
				result.getClass());
		assertThat(responseEntity).isNotNull();
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		result = responseEntity.getBody();
		assertThat(result.isEmpty()).isFalse();
		assertThat(result.size()).isEqualTo(1);
		LinkedHashMap linkedHashMap = (LinkedHashMap) responseEntity.getBody().get(0);
		assertThat(linkedHashMap).isNotNull();
		var objectMapper = new ObjectMapper();
		var verbConjugations = objectMapper.convertValue(linkedHashMap, VerbConjugations.class);
		assertThat(verbConjugations).isNotNull();
	}

	public static Stream<Arguments> getRootsForActiveTest() {
			return Stream.of(
					Arguments.of("active", "قرء", false, 3, 0),
					Arguments.of("passive", "قرء", false, 3, 0)
			);
	}
}
