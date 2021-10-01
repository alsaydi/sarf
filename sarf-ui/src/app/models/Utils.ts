import { ActivatedRoute, UrlSegment } from "@angular/router";
import { VerbSelectionDetail } from "./VerbSelectionDetail";

export class Utils
{
    private static augmented: String = 'a';
    private static unaugmented: String = 'u';
    private static tri: String = 'tri';
    private static quad: String = 'quad';

    public static getVerbSelectionDetail(route: ActivatedRoute) {
        const verb = route.snapshot.paramMap.get('verb');
        const segments: UrlSegment[] = route.snapshot.url;
        let conjugationClass = 0;
        let formula = 0;
    
        const verbSize = segments[1].path;
        const augmentation = segments[2].path;
        if (verbSize === this.tri) {
          if (augmentation === this.unaugmented) {
            conjugationClass = Number.parseInt(route.snapshot.paramMap.get('class'));
          }
          else if (augmentation === this.augmented) {
            formula = Number.parseInt(route.snapshot.paramMap.get('formula'));
          }
        }
        else if (verbSize === this.quad) {
          if (augmentation === this.augmented) {
            formula = Number.parseInt(route.snapshot.paramMap.get('formula'));
          }
        }
    
        const verbSelectionDetail: VerbSelectionDetail =
        {
          verb: verb,
          isTri: verbSize === this.tri,
          isAugmented: augmentation === this.augmented,
          formula: formula,
          conjugationClass: conjugationClass
        };
        return verbSelectionDetail;
      }
}