<div dir="rtl">

# الأسبوع التالت: توصيل الـ beans، ودورة حياتها

كود السكشن التالت من Java Spring، كلية الحاسبات والمعلومات، جامعة المنوفية.

| | |
| --- | --- |
| 📑 **السلايدز** | [`slides/`](slides) · [PDF](slides/Week%203%20-%20Slides.pdf) · [PowerPoint](slides/Week%203%20-%20Slides.pptx) |
| 📺 كل السكاشن | https://youtube.com/playlist?list=PLKZwdaKB-7u0 |

السكشن كله على مشروع واحد، `eventia`، نفس المشروع اللي سبناه الأسبوع اللي فات.

**كل خطوة عملناها في السكشن ليها commit لوحدها**، بنفس ترتيب الفيديو. اتنين
وتلاتين خطوة.

والأسبوع ده إجابة لسؤال واحد: الأسبوع اللي فات حطينا حاجات في الصندوق، طيب
**مين بيوصّلهم ببعض؟**

---

## الترتيب

ده اللي كل خطوة بتضيفه، بالترتيب:

### التوصيل من كلاس الإعداد

| | الـ tag | بيضيف إيه |
| --- | --- | --- |
| ١ | `w3-01` | نقطة البداية، نفس اللي سبناه الأسبوع اللي فات |
| ٢ | `w3-02` | كلاس `SmtpEmailSender` موجود، و Spring معرفاهوش |
| ٣ | `w3-03` | نسيب الـ scan ونعرّف الـ service بإيدنا بـ `@Bean` |
| ٤ | `w3-04` | والـ sender كمان بقى `@Bean` |
| ٥ | `w3-05` | الاتنين في الصندوق، وغريبين عن بعض |
| ٦ | `w3-06` | التوصيل بنداء مباشر للميثود |
| ٧ | `w3-07` | التوصيل بـ parameter |
| ٨ | `w3-08` | نعكس الترتيب في الملف، ونشوف مين بيتبني الأول |

### ‏`@Autowired` وتلات أماكن

| | الـ tag | بيضيف إيه |
| --- | --- | --- |
| ٩ | `w3-09` | نرجّع الـ scan، و `@Autowired` على الحقل |
| ١٠ | `w3-10` | نقلها على الـ constructor |
| ١١ | `w3-11` | والحقل بقى `final`، وده الـ constructor بس اللي بيسمح بيه |
| ١٢ | `w3-12` | نقلها على الـ setter |
| ١٣ | `w3-13` | ونشيلها خالص، و لسه شغّالة |

### الدايرة

| | الـ tag | بيضيف إيه |
| --- | --- | --- |
| ١٤ | `w3-14` | الـ sender تطلب الـ service، والـ service تطلب الـ sender |
| ١٥ | `w3-15` | نفكّ الدايرة |

### لما يبقى فيه أكتر من واحد

| | الـ tag | بيضيف إيه |
| --- | --- | --- |
| ١٦ | `w3-16` | sender تاني من نفس النوع |
| ١٧ | `w3-17` | سطر في الـ `pom`، شرط لازم للي بعده |
| ١٨ | `w3-18` | اسم الـ parameter يطابق اسم الـ bean |
| ١٩ | `w3-19` | نغيّر اسم الـ parameter بس، ونشوف اللي بيحصل |
| ٢٠ | `w3-20` | `@Primary` بدالها |
| ٢١ | `w3-21` | `@Qualifier` عند الطلب مش عند التعريف |

### والـ interface

| | الـ tag | بيضيف إيه |
| --- | --- | --- |
| ٢٢ | `w3-22` | نطلّع العقد في interface |
| ٢٣ | `w3-23` | نطلب الـ interface ومفيش حاجة بتحسم |
| ٢٤ | `w3-24` | `@Primary` على تنفيذ |
| ٢٥ | `w3-25` | `@Qualifier` يختار التنفيذ |
| ٢٦ | `w3-26` | `@Service` بدل `@Component`، ونشيل التنفيذ التاني |

### دورة الحياة

| | الـ tag | بيضيف إيه |
| --- | --- | --- |
| ٢٧ | `w3-27` | اتنين bean من كلاس واحد، والاتنين singleton |
| ٢٨ | `w3-28` | حقل بيتغيّر جوه singleton، والفاتورتين بيطلعوا غلط |
| ٢٩ | `w3-29` | 🟢 الحل: نشيل الحقل ونعمل الـ object بـ `new` جوه الميثود |
| ٣٠ | `w3-30` | `prototype`، نسخة جديدة كل مرة تطلبها |
| ٣١ | `w3-31` | `@Lazy`، وإمتى بتتبني |
| ٣٢ | `w3-32` | ننضّف التجربة ونوصل للحالة النهائية |

🟢 **وتحت في [الخطوات](#الخطوات) كل واحدة مشروحة ومعاها الناتج.**

---

## تتنقّل بينهم إزاي

الخطوات كلها على فرع `week-03` بالترتيب، وكل واحدة ليها tag.

**تشوف القايمة:**

<div dir="ltr">

```bash
git log --oneline
```

</div>

**تشوف الفرق بين خطوتين،** وده أهم أمر في الريبو ده:

<div dir="ltr">

```bash
git diff w3-09 w3-10
```

</div>

بيوريك **بالظبط** السطور اللي اتغيّرت في الخطوة دي، ولا حاجة زيادة. استخدمه وإنت
بتتفرج: كل مرة توصل لخطوة، بصّ على الـ diff بتاعها الأول وبعدين اكتبها بإيدك.

**تنطّ لخطوة وتشغّلها:**

<div dir="ltr">

```bash
git checkout w3-11
```

</div>

**وترجع لآخر حاجة:**

<div dir="ltr">

```bash
git checkout week-03
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

**من IntelliJ:** افتح فولدر `eventia` كمشروع، استنى Maven يخلّص، دوس السهم
الأخضر جنب `main`.

**ومن الـ terminal:**

<div dir="ltr">

```bash
cd eventia
./mvnw -q compile exec:java -Dexec.mainClass=com.eventia.App
```

</div>

المشروع جواه Maven wrapper فمش محتاج تنزّل Maven.

⚠️ **وعلى ويندوز استخدم PowerShell مش cmd.** `./mvnw` بيدي
`'.' is not recognized` في cmd، ولو مضطر لـ cmd استخدم `.\mvnw.cmd`.

---

## الخطوات

🟢 **الناتج المكتوب تحت متقاس من تشغيل فعلي** لكل خطوة، مش تقديري. الأرقام اللي
جنب أسامي الـ objects زي `@4076b9c0` دي عناوين في الذاكرة وبتتغيّر عندك كل
تشغيل، فمتستغربش لو لقيتها مختلفة. اللي مايتغيّرش هو **إذا كانوا نفس الرقم ولا
لأ**، وده بالظبط اللي بنقيسه.

---

# الجزء الأول: التوصيل من كلاس الإعداد

### ‏`w3-01` نقطة البداية

نفس اللي سبناه الأسبوع اللي فات بالحرف.

<div dir="ltr">

```
ahmed@example.com booked a seat for Spring Boot Workshop
beans in the context: 6
same instance? true
```

</div>

### ‏`w3-02` كلاس جديد، و Spring معرفاهوش

ضفنا كلاس `SmtpEmailSender` كامل، فيه ميثود `send`. والناتج؟

<div dir="ltr">

```
beans in the context: 6
```

</div>

**ستة، زي ما هي.** الكلاس موجود في المشروع، ومش في الصندوق. ودي نفس نقطة
`w2-13` الأسبوع اللي فات: وجود الكلاس مش معناه إن Spring تعرفه.

### ‏`w3-03` نعرّف الـ service بإيدنا

شيلنا `@ComponentScan` وعرّفنا `BookingService` بميثود `@Bean`.

<div dir="ltr">

```
BookingService created
ahmed@example.com booked a seat for Spring Boot Workshop
no sender, nothing was emailed
```

</div>

الـ service اتعملت، وحاولت تبعت، وملقتش sender. الحقل لسه فاضي.

### ‏`w3-04` والـ sender كمان

ميثود `@Bean` تانية بترجّع `SmtpEmailSender`.

<div dir="ltr">

```
SmtpEmailSender created
BookingService created
ahmed@example.com booked a seat for Spring Boot Workshop
no sender, nothing was emailed
beans in the context: 7
```

</div>

🔴 **الاتنين في الصندوق، ولسه `no sender`.** وده قلب الأسبوع كله: إن الحاجتين
موجودين مش معناه إنهم موصّلين.

### ‏`w3-05` نطبع الاتنين ونتأكد

<div dir="ltr">

```
service's sender: null
context's sender: SmtpEmailSender@4076b9c0
```

</div>

الصندوق شايل sender، والـ service شايلة `null`. مفيش حاجة بتوصّلهم.

### ‏`w3-06` التوصيل بنداء مباشر

جوه ميثود الـ `@Bean` بتاعة الـ service، نادي ميثود الـ `@Bean` التانية:

<div dir="ltr">

```java
@Bean
public BookingService bookingService() {
    return new BookingService(smtpEmailSender());
}
```

</div>

<div dir="ltr">

```
SmtpEmailSender created          ← مرة واحدة بس
BookingService created with a sender
[SMTP] -> ahmed@example.com | Booking confirmation
service's sender: SmtpEmailSender@43a90f69
context's sender: SmtpEmailSender@43a90f69
```

</div>

🟢 **بصّ على العنوانين: نفس الرقم.** ودي أهم حاجة في الخطوة دي.

إنت نادیت الميثود بإيدك زي أي ميثود عادية، فالمنطقي إنها تعمل object جديد في كل
نداء. بس `SmtpEmailSender created` اتطبعت **مرة واحدة**. يعني Spring مامشّيتش
النداء على الميثود، لأ، اعترضته وردّت عليك بالـ bean اللي هي عندها.

### ‏`w3-07` التوصيل بـ parameter

نفس النتيجة بالحرف، بطريقة تانية: خلي الميثود تطلب اللي هي محتاجاه.

<div dir="ltr">

```java
@Bean
public BookingService bookingService(SmtpEmailSender smtpEmailSender) {
    return new BookingService(smtpEmailSender);
}
```

</div>

<div dir="ltr">

```
service's sender: SmtpEmailSender@786b49ac
context's sender: SmtpEmailSender@786b49ac
```

</div>

ودي الطريقة الأحسن، لأنها بتشتغل برضه لو الـ bean معرّفة في كلاس إعداد تاني
خالص، والنداء المباشر لأ.

### ‏`w3-08` طب مين بيتبني الأول

عكسنا ترتيب الميثودين في الملف: الـ service فوق والـ sender تحت. والناتج؟

<div dir="ltr">

```
SmtpEmailSender created
BookingService created with a sender
```

</div>

**الـ sender لسه الأول.** ترتيبك في الملف مالهوش دعوة. Spring بتبني الحاجة
المطلوبة قبل اللي بيطلبها، لأنها مش بتقدر تبني الـ service من غير ما تكون
الـ sender جاهزة.

---

# الجزء التاني: `@Autowired`، وتلات أماكن

### ‏`w3-09` على الحقل

رجّعنا `@ComponentScan` وشيلنا ميثودز الـ `@Bean`، وحطينا `@Autowired` على
الحقل نفسه.

<div dir="ltr">

```
ahmed@example.com booked a seat for Spring Boot Workshop
[SMTP] -> ahmed@example.com | Booking confirmation
beans in the context: 7
```

</div>

### ‏`w3-10` على الـ constructor

### ‏`w3-11` والحقل بقى `final`

### ‏`w3-12` على الـ setter

🔴 **التلات خطوات دول ناتجهم واحد بالحرف.** جرّب `git diff w3-09 w3-12` وبعدين
شغّل الاتنين، ومش هتفرق من الكونسول أنهي واحدة شغّالة.

فالفرق بينهم مش في السلوك، ومش في القيمة اللي بتتحقن. الفرق في حاجة واحدة:
**إيه اللي الكومبايلر يقدر يمنعك منه.**

وجرّب دي بنفسك على `w3-11`: شيل الـ `@Autowired` من الـ constructor، وحطّها على
الحقل وسيب الحقل `final`. مش هيترجم:

<div dir="ltr">

```
variable emailSender not initialized in the default constructor
```

</div>

ودي رسالة من `javac` مش من Spring. السبب إن الحقن على الحقل بيحصل **بعد** ما
الـ object يتبني، والـ `final` لازم تتملا **وقت** البناء.

### ‏`w3-13` ونشيلها خالص

شيلنا `@Autowired` من كل حتة، والـ constructor فضل زي ما هو.

<div dir="ltr">

```
[SMTP] -> ahmed@example.com | Booking confirmation
```

</div>

**لسه شغّالة.** لما يكون فيه constructor واحد بس، Spring بتاخده على إنه المقصود
من غير ما تقولها. وده السبب اللي مش هتشوف `@Autowired` في كود Spring Boot من
الأسبوع الجاي.

🔴 **وخد بالك:** لو عملت constructor تاني من غير parameters، Spring هتختار
الفاضي في سكوت والحقل هيفضل `null`. ساعتها لازم `@Autowired` على اللي إنت
عايزه.

---

# الجزء التالت: الدايرة

### ‏`w3-14` نعمل دايرة بإيدنا

الـ service بتطلب الـ sender في الـ constructor، وخلّينا الـ sender تطلب الـ
service في الـ constructor بتاعها.

<div dir="ltr">

```
Error creating bean with name 'bookingService':
  Unsatisfied dependency expressed through constructor parameter 0:
Error creating bean with name 'smtpEmailSender':
  Unsatisfied dependency expressed through constructor parameter 0:
Error creating bean with name 'bookingService':
  Requested bean is currently in creation:
  Is there an unresolvable circular reference?
```

</div>

اقرا الرسالة من فوق لتحت: `bookingService` محتاجة `smtpEmailSender`، واللي
محتاجة `bookingService`، واللي **لسه بتتبني**.

🔴 **والرسالة بترسملك الدايرة بنفسها.** لو شفت `currently in creation` في شغلك،
ده معناه دايرة، وتقرا الأسامي بالترتيب تلاقيها.

والحل مش annotation. الحل إنك تسأل نفسك ليه الكلاسين محتاجين بعض، وتعيد توزيع
المسؤوليات.

### ‏`w3-15` نفكّ الدايرة

شيلنا الاعتماد من ناحية واحدة، والدنيا رجعت.

---

# الجزء الرابع: لما يبقى فيه أكتر من واحد

### ‏`w3-16` sender تاني من نفس النوع

‏`BackupEmailSender` عليها `@Component` زي الأولانية.

<div dir="ltr">

```
No qualifying bean of type 'SmtpEmailSender' available:
  expected single matching bean but found 2:
  backupEmailSender,smtpEmailSender
```

</div>

نفس رسالة `w2-08` الأسبوع اللي فات. طلبنا نوع وفيه اتنين منه.

### ‏`w3-17` سطر في الـ `pom`

<div dir="ltr">

```xml
<parameters>true</parameters>
```

</div>

**والناتج هو هو، نفس الخطأ بالحرف.** السطر ده مش حل، هو شرط لازم للي بعده.

من غيره الكومبايلر مابيحفظش أسامي الـ parameters في ملف الـ `class`، فـ Spring
مش بتقدر تختار bean باسم الـ parameter. وعشان تتأكد بنفسك:

<div dir="ltr">

```bash
javap -v target/classes/com/eventia/service/BookingService.class | findstr MethodParameters
```

</div>

من غير السطر مش هتلاقي حاجة، ومعاه هتلاقي `MethodParameters`.

🟢 **ومن الأسبوع الجاي Spring Boot بتحطّه لوحدها**، فمش هتكتبه تاني.

### ‏`w3-18` الاسم يطابق

سمّينا الـ parameter `backupEmailSender`، نفس اسم الـ bean التانية.

<div dir="ltr">

```
[BACKUP] -> ahmed@example.com | Booking confirmation
```

</div>

### ‏`w3-19` نغيّر الاسم بس، ولا حرف تاني

<div dir="ltr">

```
[SMTP] -> ahmed@example.com | Booking confirmation
```

</div>

🔴 **غيّرنا اسم parameter، والتنفيذ اللي اشتغل اتغيّر.** دي القاعدة الأولى:
Spring بتدوّر على bean اسمها زي اسم الـ parameter.

وخد بالك إنها حساسة ومبنية على اسم، فلو حد عمل rename للـ parameter وهو
بينضّف الكود، السلوك بيتغيّر وهو مش حاسس.

### ‏`w3-20` `@Primary`

<div dir="ltr">

```java
@Component
@Primary
public class BackupEmailSender { ... }
```

</div>

<div dir="ltr">

```
[BACKUP] -> ahmed@example.com | Booking confirmation
```

</div>

القاعدة التانية. الفرق إنها بتتحدد **عند التعريف**، يعني إجابة لكل الطلبات.

### ‏`w3-21` `@Qualifier`

<div dir="ltr">

```java
public BookingService(@Qualifier("backupEmailSender") EmailSender sender)
```

</div>

القاعدة التالتة، وبتتحدد **عند الطلب**، فكل طالب يقدر يختار غير التاني.

🟢 **والترتيب اللي Spring بتمشي بيه:** الاسم الأول، وبعدين `@Primary`، وبعدين
`@Qualifier`. ولو مفيش ولا واحدة، بترمي.

---

# الجزء الخامس: الـ interface

### ‏`w3-22` نطلّع العقد

<div dir="ltr">

```java
public interface EmailSender {
    void send(String to, String subject, String body);
}
```

</div>

والـ service بقت تطلب `EmailSender` مش `SmtpEmailSender`.

**والناتج هو هو بالحرف.** اللي اتغيّر إن الـ service بطّلت تعرف مين بيبعت.

### ‏`w3-23` نطلبه ومفيش حاجة بتحسم

<div dir="ltr">

```
No qualifying bean of type 'EmailSender' available:
  expected single matching bean but found 2
```

</div>

### ‏`w3-24` `@Primary` على تنفيذ

### ‏`w3-25` `@Qualifier` يختار التنفيذ

🟢 **نفس التلات قواعد بالحرف، ومفيش ميكانيكا جديدة خالص.** سواء اللي بتطلبه
كلاس أو interface، نفس الترتيب بيحسم.

### ‏`w3-26` `@Service` ونشيل التنفيذ التاني

‏`@Service` هي `@Component` بالظبط، بلافتة مختلفة بتقول للي بيقرا إن ده منطق
شغل. ومعاها `@Repository` للي بيتكلم مع قاعدة البيانات.

<div dir="ltr">

```
beans in the context: 7
```

</div>

---

# الجزء السادس: دورة الحياة

### ‏`w3-27` الـ singleton، والاسم المضلّل

ميثودين `@Bean` بيرجّعوا نفس الكلاس `Printer`.

<div dir="ltr">

```
beans in the context: 9
deskPrinter : desk@561482983
backPrinter : back@1993964182
same object? false
by hand     : desk@1352726782
```

</div>

🔴 **تلات نسخ من كلاس واحد، والاتنين الأولانيين singletons.**

يعني الـ singleton في Spring **مش** الـ Singleton اللي اتعلمتوه. الفرق:

| | |
| --- | --- |
| الـ Singleton في كتب التصميم | نسخة واحدة في البرنامج كله، والكلاس نفسه بيمنع التانية |
| الـ singleton في Spring | نسخة واحدة **لكل اسم bean**، في **كل context**. والكلاس عادي و `new` لسه شغّالة |

### ‏`w3-28` ومشكلة النسخة الواحدة

‏`InvoiceBuilder` فيها حقلين بيتغيّروا، وشغّلناها من thread لكل حاجز، زي أي
سيرفر.

<div dir="ltr">

```
mona owes 350
mona owes 350
ahmed should owe 100, and mona should owe 250
```

</div>

اسم أحمد اتمسح لما منى بدأت، والمبلغين اتجمعوا. **والفاتورتين غلط، مش واحدة.**

🔴 **وده مش bug في Spring.** ده إنك حطّيت حالة بتتغيّر في حاجة الكل بيشاركها.
وعلى جهازك لوحدك مش هيبان خالص.

### ‏`w3-29` 🟢 الحل

اسأل الأول: الـ `Invoice` دي محتاجة إيه من Spring؟ **ولا حاجة.** فليه بقت bean؟

شيلنا الحقول من الـ service، وخلّينا الـ `Invoice` كلاس عادي بيتعمل بـ `new`
جوه الميثود:

<div dir="ltr">

```java
String bill(String customer, int seatPrice, int seats) {
    Invoice invoice = new Invoice(customer);   // محلي، لكل نداء
    ...
}
```

</div>

<div dir="ltr">

```
one service object for both: BillingService@7d74fcba
ahmed owes 100
mona owes 250
```

</div>

الـ service لسه نسخة واحدة للاتنين، شايفين العنوان الواحد. والإجابتين صح، **من
غير أي scope ولا أي annotation**.

🔴 **والقاعدة اللي تمشي بيها:** الحاجة تبقى bean لما تحتاج حاجة من الصندوق، أو
لما حد تاني يحتاجها. غير كده، `new` وخلاص. ومتخليش Spring تدير كل object في
البرنامج، دي مش وظيفتها.

### ‏`w3-30` وفيه scope تاني، اسمه `prototype`

<div dir="ltr">

```java
@Scope("prototype")
@Service
public class InvoiceBuilder { ... }
```

</div>

<div dir="ltr">

```
context ready
InvoiceBuilder created
InvoiceBuilder created
same object? false
```

</div>

طلبناها مرتين فاتعملت مرتين. ده اللي `prototype` بتعمله.

🟢 **بس اللي في الخطوة اللي فاتت هو اللي هتستخدمه.** الـ `prototype` نادر
جدًا، وفيه تفاصيل فيه بتلخبط لما تحقنه في حاجة تانية. المطلوب منك هنا إنك
تعرف الاسم وتعرف بيعمل إيه، عشان لو شفته في كود تبقى فاهم.

### ‏`w3-31` `@Lazy`

<div dir="ltr">

```
beans in the context: 8
context ready, I have asked for nothing yet
TicketPrinter created          ← دلوقتي بس
now I asked
```

</div>

الـ context خلص وهي لسه ماتعملتش، واتعملت عند أول طلب.

**وليه مانخليش كله lazy؟** عشان الـ eager بيكشف المشاكل بدري. لو فيه bean
إعدادها غلط، عايزها تقع وإنت بتشغّل وشايف الشاشة، مش الساعة تلاتة بالليل أول
ما مستخدم يفتح الصفحة دي.

### ‏`w3-32` ننضّف ونوصل للحالة النهائية

شيلنا كل تجارب دورة الحياة، والمشروع رجع نضيف.

<div dir="ltr">

```
[SMTP] -> ahmed@example.com | Booking confirmation
beans in the context: 7
same instance? true
```

</div>

---

## جرّب تكسره بنفسك

ابدأ من آخر الفرع، وبعد كل تجربة رجّع بـ `git checkout -- .`

| اعمل إيه | هتشوف إيه |
| --- | --- |
| حطّ `@Autowired` على حقل `final` | `variable emailSender not initialized in the default constructor`، ومن `javac` مش من Spring |
| على `w3-09`، اعمل `new BookingService()` في `App` من غير context خالص | بيترجم، وبيطبع أول سطر، وبعدين `NullPointerException` |
| نفس السطر على `w3-13` | مش بيترجم أصلاً، والكومبايلر بيقولك لازم تمرّر sender |
| ضيف constructor تاني فاضي لـ `BookingService` على `w3-13` | بيشتغل في سكوت، والـ sender بقت `null` |
| على `w3-18`، شيل `<parameters>true</parameters>` من الـ `pom` | `expected single matching bean but found 2: backupEmailSender,smtpEmailSender` ترجع |
| حطّ `@Primary` على التنفيذين | `more than one 'primary' bean found among candidates: [backupEmailSender, smtpEmailSender]` |

🔴 **والتجربتين التانية والتالتة دول هما الفرق الحقيقي** بين الحقن على الحقل
والحقن على الـ constructor. الأولانية سمحتلك تبني object مكسور، والتانية منعتك.
وده بالظبط اللي بيحصل في الاختبارات.

---

## تذاكر منين

الكتاب **Spring Start Here** لـ Laurentiu Spilca، الفصل التالت والخامس.
والمؤلف نفسه شارحه فصل فصل:

| | |
| --- | --- |
| البلاي ليست | https://youtube.com/playlist?list=PLEocw3gLFc8W25hvuYb6EERd3F0aZjUQF |
| الفصل التالت | https://www.youtube.com/watch?v=Aca1VEXk0dc |
| الفصل الخامس | https://www.youtube.com/watch?v=s8X-n_QQUf0 |

🔴 **وحاجتين عدّيهم:** الفصل الرابع كله (كلام تصميم، والميكانيكا بتاعته هي
نفس قواعد الفصل التالت)، و `ObjectProvider` في آخر الفصل الخامس.

---

## الأسبوع الجاي

لسه بنكتب الإعداد كله بإيدنا: الـ context، و `pom` فيه كل dependency وكل إصدار
مكتوبين، و `@ComponentScan` بتقول ندوّر فين.

الأسبوع الجاي **Spring Boot**، والسطور دي كلها بتختفي.

---

‏Eng. Mohamed Shehab

</div>
