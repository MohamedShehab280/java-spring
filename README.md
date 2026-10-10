<div dir="rtl">

# الأسبوع التاني: اللوجز، وأول bean

كود السكشن التاني من Java Spring، كلية الحاسبات والمعلومات، جامعة المنوفية.

| | |
| --- | --- |
| 🎬 **الفيديو** | https://youtu.be/D4eaNJkwoc0 |
| 📑 **السلايدز** | [`slides/`](slides) · [PDF](slides/Week%202%20-%20Slides.pdf) · [PowerPoint](slides/Week%202%20-%20Slides.pptx) |
| 📝 **التاسك** | [الورقة](task/Week%202%20-%20Task.pdf) · [المشروع الجاهز](task/eventia-starter.zip) |
| 📺 كل السكاشن | https://youtube.com/playlist?list=PLKZwdaKB-7u0 |

السكشن نصين، وفي الريبو مشروعين:

| الفولدر | إيه هو |
| --- | --- |
| `booking-logs` | النص الأول. مشروع Maven عملناه قدامكم من الصفر عشان اللوجز |
| `eventia` | النص التاني. مشروع الكورس، وأول لمسة مع Spring |

**كل خطوة عملناها في السكشن ليها commit لوحدها**، بنفس ترتيب الفيديو. إحدى عشر
خطوة في المشروع الأول، وستاشر في التاني.

---

## الترتيب

ده اللي كل خطوة بتضيفه، بالترتيب:

### ‏`booking-logs` · اللوجز

| | الـ tag | بيضيف إيه |
| --- | --- | --- |
| ١ | `bs-01` | مشروع Maven جديد، و dependency واحدة |
| ٢ | `bs-02` | اللوجر وتلات سطور لوج، وتشغيل من غير أي إعداد |
| ٣ | `bs-03` | `logback.xml` فيه العتبة بس، فالدنيا بتسكت |
| ٤ | `bs-04` | `debug="true"`، والسبب بيطلع في التقرير |
| ٥ | `bs-05` | الـ appender، والناتج بيرجع |
| ٦ | `bs-06` | `warn` و `error` جنب بعض |
| ٧ | `bs-07` | الاستثناء آخر باراميتر، والـ stack trace بيطلع |
| ٨ | `bs-08` | لوجر تاني، وعتبة لكل واحد لوحده |
| ٩ | `bs-09` | `@Slf4j` بدل سطر اللوجر |
| ١٠ | `bs-10` | كلاس `Booking` بـ `@Getter` و `@Setter` |
| ١١ | `bs-11` | `@Data` بدل الاتنين |

### ‏`eventia` · Spring context

| | الـ tag | بيضيف إيه |
| --- | --- | --- |
| ١ | `w2-01` | نقطة البداية، `App` فاضية ومفيش Spring |
| ٢ | `w2-02` | dependency الـ `spring-context` |
| ٣ | `w2-03` | `AppConfig` فاضية عليها `@Configuration` |
| ٤ | `w2-04` | نبني الـ context، ونعدّ: خمسة |
| ٥ | `w2-05` | نطبع أسامي الخمسة |
| ٦ | `w2-06` | نطلب `Event` مش موجودة، فبيرمي |
| ٧ | `w2-07` | أول `@Bean` بإيدك، والعدد بقى ستة |
| ٨ | `w2-08` | تانية من نفس النوع، فبيرمي تاني |
| ٩ | `w2-09` | نطلبهم بالاسم، فبيشتغل |
| ١٠ | `w2-10` | `@Bean("mainEvent")` بتغيّر الاسم |
| ١١ | `w2-11` | `@Primary` على واحدة |
| ١٢ | `w2-12` | `@Bean` لكلاس مش بتاعنا، `Clock` |
| ١٣ | `w2-13` | `BookingService` من غير annotation، والعدد مابيتغيّرش |
| ١٤ | `w2-14` | التحويل لـ `@Component` و `@ComponentScan` |
| ١٥ | `w2-15` | نطبع الأسامي تاني، والاسم جه من الكلاس |
| ١٦ | `w2-16` | لوج في الـ constructor، وإمتى بيتنفّذ |

🟢 **وتحت في [الخطوات](#الخطوات) كل واحدة مشروحة بالتفصيل ومعاها الناتج.**

---

## تتنقّل بينهم إزاي

الخطوات كلها على فرع `week-02` بالترتيب، وكل واحدة ليها tag.

**تشوف القايمة:**

<div dir="ltr">

```bash
git log --oneline
```

</div>

**تشوف الفرق بين خطوتين،** وده أهم أمر في الريبو ده:

<div dir="ltr">

```bash
git diff bs-05 bs-06
```

</div>

بيوريك **بالظبط** السطور اللي اتكتبت في الخطوة دي، ولا حاجة زيادة. استخدمه وإنت
بتتفرج: كل مرة توصل لخطوة، بصّ على الـ diff بتاعها الأول وبعدين اكتبها بإيدك.

**تنطّ لخطوة وتشغّلها:**

<div dir="ltr">

```bash
git checkout w2-07
```

</div>

**وترجع لآخر حاجة:**

<div dir="ltr">

```bash
git checkout week-02
```

</div>

**ولو عدّلت وعايز ترجّع:**

<div dir="ltr">

```bash
git checkout -- .
```

</div>

---

## تشغّله إزاي

**من IntelliJ:** افتح الفولدر كمشروع، استنى Maven يخلّص، دوس السهم الأخضر جنب
`main`. دي نفس الطريقة اللي اشتغلنا بيها في السكشن.

**ومن الـ terminal،** لو مفضّل:

<div dir="ltr">

```bash
cd eventia
./mvnw -q compile exec:java -Dexec.mainClass=com.eventia.App
```

</div>

<div dir="ltr">

```bash
cd booking-logs
mvn -q compile exec:java -Dexec.mainClass=org.example.Main
```

</div>

‏`eventia` جواه Maven wrapper فمش محتاج تنزّل حاجة. `booking-logs` لأ، فلو طلعلك
`mvn is not recognized` شغّله من IntelliJ وخلاص، أو افتح الـ terminal من جوه
IntelliJ لإنها بتحطّ الـ Maven بتاعتها في الـ PATH.

⚠️ **وعلى ويندوز استخدم PowerShell مش cmd.** `./mvnw` بيدي `'.' is not recognized`
في cmd.

---

## الخطوات

🟢 **الناتج المكتوب تحت متقاس من تشغيل فعلي**، مش تقديري. والوقت وأرقام الـ
stack trace هي اللي بتتغيّر عندك طبعًا.

---

# النص الأول: اللوجز

### ‏`bs-01` المشروع الجديد

‏`pom.xml` فيه dependency واحدة، `logback-classic`. والمشروع لسه فاضي.

جرّب `mvn dependency:tree` وشوف: dependency واحدة جابت **تلات** jars.

### ‏`bs-02` اللوجر، وتشغيل من غير أي إعداد

تلات سطور لوج في الكود. طب طلع كام؟

<div dir="ltr">

```
DEBUG org.example.Main -- found 2 seats
INFO  org.example.Main -- booking started
```

</div>

اتنين. `trace` اتفلتر، لأن logback من غير ملف إعداد بيبدأ من `DEBUG`.

### ‏`bs-03` نحطّ `logback.xml` فيه العتبة بس

<div dir="ltr">

```
(مفيش ناتج خالص)
```

</div>

السكوت ده مقصود. حطينا ملف إعداد ناقص فالدنيا سكتت. فكّر ليه قبل ما تكمّل.

### ‏`bs-04` `debug="true"`، والسبب بيطلع

‏logback بيطبع تقرير بـ ١٦ سطر عن اللي عمله. **آخر سطر فيه هو الإجابة:**

<div dir="ltr">

```
|-WARN in Logger[org.example.Main] - No appenders present in context [default]
```

</div>

والـ appender ده هو المكان اللي اللوج بيروحله: الكونسول، أو ملف، أو السيرفر.
يعني العتبة بتقول «أنهي رسايل تعدّي» والـ appender بيقول «وتروح فين». إحنا
حطينا العتبة ونسينا المكان، فالرسايل عدّت وملقتش حتة تروحلها.

### ‏`bs-05` الـ appender، والناتج يرجع

‏`ConsoleAppender` بـ `pattern`. وجرّب تغيّر `level` من `debug` لـ `info` وشوف
الفرق بعينك.

### ‏`bs-06` `warn` و `error` جنب بعض

<div dir="ltr">

```
WARN  org.example.Main - only 2 seats left, asked for 5
ERROR org.example.Main - could not send confirmation
```

</div>

**والفرق بينهم في المعنى مش في الشكل.** الطلب المرفوض مش `error`، لأن النظام
شغّال صح وبيرفض زي ما المفروض. الـ `error` للحاجة اللي اتكسرت فعلاً.

### ‏`bs-07` الاستثناء آخر باراميتر، من غير أقواس

نفس الرسالة مكتوبة مرتين، والفرق إن التانية مضاف ليها `e`:

<div dir="ltr">

```java
log.error("could not send confirmation");
log.error("could not send confirmation", e);
```

</div>

والتانية بس هي اللي طلّعت الـ stack trace. 🔴 **دي أكتر غلطة بتتعمل في اللوجز.**

### ‏`bs-08` لوجر تاني، وعتبة لكل واحد

لوجر اسمه `database`، وفي `logback.xml` كل واحد بياخد عتبة مختلفة. النتيجة إن
`database` سكت و `org.example` فضل شغّال، **من غير ما نغيّر حرف في الكود**.

ودي اللي بتخليك تفتح `DEBUG` على جزء واحد من البرنامج وإنت في مشكلة، من غير ما
تغرق في لوجز الباقي.

### ‏`bs-09` `@Slf4j` بتكتب سطر اللوجر مكانك

اشطب السطر ده:

<div dir="ltr">

```java
private static final Logger log = LoggerFactory.getLogger(Main.class);
```

</div>

وحطّ `@Slf4j` فوق الكلاس. **سطور اللوج هي هي بالحرف.**

واللي اتغيّر: أرقام الـ stack trace نزلت **أربعة**، لأن الملف قصر أربع سطور.

وعشان تتأكد إن السطر لسه موجود فعلاً:

<div dir="ltr">

```bash
javap -p target/classes/org/example/Main.class
```

</div>

هتلاقي `private static final org.slf4j.Logger log;` قدامك. Lombok كتبته وقت
الترجمة.

### ‏`bs-10` `@Getter` و `@Setter`

كلاس `Booking` فيه تلات حقول وبس. شغّل `javap` عليه وهتلاقي **ستة** ميثودز
اتكتبوا لوحدهم.

والناتج في الكونسول:

<div dir="ltr">

```
the booking: org.example.Booking@45e5696d
```

</div>

عنوان في الذاكرة، مش حاجة تنفع.

### ‏`bs-11` `@Data` بتلمّهم وتزوّد

واحدة بدل الاتنين، و `javap` بقى بيوري **عشرة** بدل ستة: زودت `equals` و
`hashCode` و `toString` و `canEqual`.

وبسبب `toString` الجديدة:

<div dir="ltr">

```
the booking: Booking(user=ahmed@example.com, eventTitle=Spring Boot Workshop, seats=5)
```

</div>

---

# النص التاني: Spring context

الرحلة دي بتبدأ من صفحة بيضا. `App` فاضية، ومفيش Spring خالص.

### ‏`w2-01` نقطة البداية

‏`Event` موجودة، وهي اللي هنحطها في الصندوق.

### ‏`w2-02` نضيف `spring-context`

**الناتج هو هو بالحرف.** ضفنا مكتبة ومستخدمناهاش.

### ‏`w2-03` كلاس إعداد فاضي

‏`AppConfig` عليها `@Configuration` وجواها ولا حاجة. الناتج لسه هو هو.

### ‏`w2-04` نبني الـ context

<div dir="ltr">

```java
var context = new AnnotationConfigApplicationContext(AppConfig.class);
```

</div>

<div dir="ltr">

```
beans in the context: 5
```

</div>

**خمسة؟ وإحنا مكتبناش ولا واحدة.**

### ‏`w2-05` طب مين الخمسة دول

<div dir="ltr">

```
   org.springframework.context.annotation.internalConfigurationAnnotationProcessor
   org.springframework.context.annotation.internalAutowiredAnnotationProcessor
   org.springframework.context.event.internalEventListenerProcessor
   org.springframework.context.event.internalEventListenerFactory
   appConfig
```

</div>

أربعة بتوع Spring نفسها، والخامس هو كلاس الإعداد بتاعنا. يعني **الصندوق بيبدأ
فاضي من حاجتنا إحنا**.

### ‏`w2-06` نطلب حاجة مش موجودة

<div dir="ltr">

```
No qualifying bean of type 'com.eventia.model.Event' available
```

</div>

🔴 **وجرّب دي كمان:** اعمل `new Event(...)` بإيدك وبعدين عدّ تاني. هتلاقيه لسه
**٥**. الـ object اللي إنت عملته مش موجود عند Spring أصلاً، وهي معندهاش فكرة
إنه اتعمل.

### ‏`w2-07` أول `@Bean` بإيدك

<div dir="ltr">

```java
@Bean
public Event workshop() {
    return new Event("Spring Boot Workshop", 40);
}
```

</div>

<div dir="ltr">

```
beans in the context: 6
   workshop
```

</div>

العدد بقى ٦، والاسم `workshop`. يعني **اسم الميثود** هو اسم الـ bean.

### ‏`w2-08` اتنين من نفس النوع

ميثود تانية بترجّع `Event` كمان. العدد بقى **٧**، والطلب بالنوع بيرمي:

<div dir="ltr">

```
expected single matching bean but found 2: workshop,conference
```

</div>

منطقي. طلبت `Event` وفيه اتنين، فمين فيهم؟

### ‏`w2-09` الحل الأول: بالاسم

<div dir="ltr">

```
by name workshop   -> Spring Boot Workshop
by name conference -> Java Conference
same twice? true
```

</div>

🟢 **وخد بالك من `same twice? true`.** طلبتها مرتين وجت نفس الـ instance. دي
الـ singleton، وهي السلوك الافتراضي.

### ‏`w2-10` والاسم مش سحر، إنت اللي بتحدده

‏`@Bean("mainEvent")`، والاسم بيتغيّر، والطلب القديم بقى بيرمي:

<div dir="ltr">

```
No bean named 'workshop' available
```

</div>

### ‏`w2-11` الحل التاني: `@Primary`

‏`@Primary` على واحدة منهم، والطلب بالنوع رجع يشتغل من غير أي اسم.

### ‏`w2-12` وكلاس مش بتاعك أصلاً

‏`java.time.Clock` مش كلاس إحنا كاتبينه، يعني مش هنقدر نحطّ عليه annotation. بس
نقدر نرجّعه من ميثود عليها `@Bean`:

<div dir="ltr">

```
beans in the context: 8
   clock
```

</div>

🔴 **ودي أهم فايدة لـ `@Bean`:** الكلاسات اللي جاية من مكتبات تانية.

### ‏`w2-13` نعمل الـ service

‏`BookingService` كلاس عادي من غير أي annotation. **والعدد لسه ٨.** الكلاس موجود
في المشروع و Spring معرفاهوش.

### ‏`w2-14` التحويل: كلمة واحدة فوق الكلاس

امسح ميثودز الـ `@Bean` كلها، وحطّ `@Component` فوق `BookingService` و
`@ComponentScan` على `AppConfig`.

<div dir="ltr">

```
beans in the context: 6
same instance? true
```

</div>

نفس الصندوق بباب تاني، و `AppConfig` رجعت فاضية.

🟢 **واسأل نفسك:** لو ضفت كلاس جديد وحطيت عليه `@Component`، هتعدّل في `AppConfig`
إيه؟ الإجابة ولا حرف.

### ‏`w2-15` والاسم جه منين المرة دي

<div dir="ltr">

```
   bookingService
```

</div>

بأول حرف صغير، **من اسم الكلاس**. مش من اسم ميثود زي الأول.

### ‏`w2-16` اتعملوا قبل ما تطلب

حطّ سطر لوج في الـ constructor بتاع `BookingService` وبصّ على الترتيب:

<div dir="ltr">

```
building the context now
constructor ran
context ready, I asked for nothing yet
now I asked
ahmed@example.com booked a seat for Spring Boot Workshop
```

</div>

🔴 **الـ constructor اشتغل قبل `getBean`، ومااشتغلش تاني بعدها.** يعني Spring
بتبني الـ beans وقت ما بتجهّز الـ context، مش وقت ما إنت بتطلب.

---

## جرّب تكسره بنفسك

ابدأ من آخر الفرع، وبعد كل تجربة رجّع بـ `git checkout -- .`

| اعمل إيه | هتشوف إيه |
| --- | --- |
| امسح `@Component` من `BookingService` | `No qualifying bean of type 'com.eventia.service.BookingService' available` |
| رجّعها، وخلي `basePackages` تبقى `"com.other"` | **نفس الرسالة بالحرف** |

نفس الرسالة وسببين مختلفين تمامًا: مرة الورقة ناقصة، ومرة مكان البحث غلط.

---

## تذاكر منين

الكتاب **Spring Start Here** لـ Laurentiu Spilca، الفصل الأول والتاني. والمؤلف
نفسه شارحه فصل فصل:

| | |
| --- | --- |
| البلاي ليست | https://youtube.com/playlist?list=PLEocw3gLFc8W25hvuYb6EERd3F0aZjUQF |
| الفصل الأول، حلقة ١ | https://www.youtube.com/watch?v=EhfUdb6do54 |
| الفصل التاني، حلقة ٢ | https://www.youtube.com/watch?v=b8ocrkawS38 |
| الفصل التاني، حلقة ٣ | https://www.youtube.com/watch?v=uj9St3Rcehg |

🟢 الفيديو ماشي بنفس ترتيب السكشن: `@Bean` الأول وبعدين `@Component`.

🔴 **وحاجة واحدة بس عدّيها:** جزء `registerBean` في آخر الفصل التاني. مش في
السكشن ومش محتاجينه.

**واللوجز مش في الكتاب خالص.** الكتاب ١٥ فصل ومفيهوش ولا فصل عن اللوجينج،
فالنص الأول مصدره السكشن نفسه.

</div>
