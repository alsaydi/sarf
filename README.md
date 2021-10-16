# Sarf
## Sarf - Arabic Morphology System

I found the source code posted on sourceforge here https://sourceforge.net/projects/sarf/files/sarf/sarf%201.0/. 
The code is also hosted by others. Here is an example: https://raw.githubusercontent.com/linuxscout/sarf.

[![downloads]( https://img.shields.io/sourceforge/dt/sarf.svg)](http://sourceforge.org/projects/sarf)
[![downloads]( https://img.shields.io/sourceforge/dm/sarf.svg)](http://sourceforge.org/projects/sarf)

The original Sarf code contains a tremendous effort and handles numerous cases. 
Also, it has invaluable documentation [Documentations](Documentations) 

I wanted to keep the Sarf program available for others who may find it useful for their purposes.

My goal in here is:
* Keep the core library [sarf-library](sarf-library) as up-to-date as possible
* Allow it to be usable as a stand-alone library for others to build on if they wish
* Add tests - see the [sarf-library-tests](sarf-library-tests) 
  * These tests are BDD tests; the coverage isn't 100% but it's a decent coverage
  * They can take up to 15 minutes to run
  * They run as part of each check-in
* Build an interface around the core library
  * I added a web service using Spring Boot [sarf-web-service](sarf-web-service)
  * A web interface is also available [sarf-ui](sarf-ui). It uses Angular. You can try it here, [https://sarf.one](https://sarf.one)

If you want to use the API, you can either build and run the code locally or a server. You can also pull a docker image if you wish, for example: 
```
docker run --rm alsaydi/sarf:1.3
```
If you prefer to run the desktop client, assuming you have the required build tools, (maven and JDK)

```bash
mvn clean compile -Dmaven.test.skip
java -jar sarf-library/target/sarf-library-1.0.1-SNAPSHOT-jar-with-dependencies.jar
```

Feel free to reach out or open an issue if you'd like help.

# نظام الاشتقاق والتصريف في اللغة العربية
لما رأيت مصدر هذا البرنامج، أدركت قدر الجهد الكبير الذي بذل من أجل تكوينه. فأردت أن لا يذهب البرنامج هباءً.
أحببت أن أجعل البرنامج متاحاً لعل آخرين يستفيدون منه. فرب حامل فقه إلى من هو أفقه منه.

هذا البرنامج صمم بدعم ن المنظمة العربية للتربية والثقافة والعلوم
[ألكسو](https://ossl.alecso.org/affich_oso_details.php?id=55)

هكذا وصف البرنامج الأصل من مصدره.
يرمي هذا النظام إلى اشتقاق (توليد) الأفعال والأسماء المشتقة والمصادر، وتصريفها، انطلاقاً من جذورها الثلاثية أو الرباعية، واعتماداً على قوانين النحو والصرف، وعلى قواعد المعطيات الخاصة به.

## يقوم هذا النظام:

### 1- باشتقاق (توليد):
* الأفعال الثلاثية والرباعية، المجردة والمزيدة.
* الأسماء المشتقة القياسية (اعتماداً على قوانين الاشتقاق)، والسماعية (اعتماداً على قواعد المعطيات).
* المصادر القياسية (اعتماداً على قوانين الاشتقاق)، والسماعية (اعتماداً على قواعد المعطيات).

### 2- بتصريف:

* الأفعال عند إسنادها إلى جميع الضمائر، في صيغة الماضي، والمضارع المرفوع والمنصوب والمجزوم والمؤكد، والأمر المؤكد وغير المؤكد.
* الأفعال في حالة بنائها للمعلوم والمجهول.
*  الأسماء المشتقة والمصادر، في حالة الإفراد والتثنية والجمع، والتذكير والتأنيث، والرفع والنصب والجر، مع مراعاة الاسم من جهة تنكيره، وتعريفه، وإضافته.

### أهم المزايا اللغوية لنظام الاشتقاق والتصريف
* استيعابه جميع الأفعال الثلاثية والرباعية في اللغة العربية. (أكثر من 24,000 فعل ثلاثي ورباعي)
* استيعابه جميع المصادر السماعية للأفعال الثلاثية. (قرابة 14,400 مصدر)
* قدرته على توليد جميع الأسماء المشتقة، والمصادر القياسية. (أكثر من 80,000 اسم مشتق ومصدر)
* استغراقه جميع قواعد النحو والصرف المتعلقة باشتقاق وتصريف الأفعال والأسماء والمصادر، وكذلك قواعد التصريف المشترك (الإعلال، والإبدال، والإدغام).
* استغراقه جميع قواعد رسم الهمزة، سواء أكانت في الأفعال أم في الأسماء.
* ضبطه التام للكلمات بالشكل (بالحركات).

# Credit
* الفريق الذي قام بتطوير البرنامج الأصل كماأشير إلى ذلك أعلاه -
--
###        منسق المشروع لدى المنظمة العربية للتربية والثقافة والعلوم
د. أمين القلق

###   فريق العمل:

أ. مروان البواب

م. هيثم محتسب بالله

د. محمد مراياتي

د. محمد حسان الطيان

د. يحيى مير علم

د. محمد مكي الحسني

أ. صفاء العطار

م.م. اسامة رجب

### مستشار برمجي:
د. حسن السيد
