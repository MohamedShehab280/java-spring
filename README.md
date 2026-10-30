<div dir="rtl">

# الأسبوع الرابع: Spring Boot، و HTTP، و REST API بتلات طبقات

كود السكشن الرابع من Java Spring، كلية الحاسبات والمعلومات، جامعة المنوفية.

| | |
| --- | --- |
| 📑 **السلايدز** | [`slides/`](slides) · [PDF](slides/Week%204%20-%20Slides.pdf) · [PowerPoint](slides/Week%204%20-%20Slides.pptx) |
| 📺 كل السكاشن | https://youtube.com/playlist?list=PLKZwdaKB-7u0 |

المشروع جديد: **اللي start.spring.io بيعمله**، Spring Boot 4.1.2 و Spring Web، واسمه
`eventia`. وبنبني عليه API كامل.

**كل خطوة عملناها في السكشن ليها commit لوحدها**، بنفس الترتيب. سبعتاشر خطوة.

والأسبوع ده بيجاوب على سؤالين: **المشروع بيبقى سيرفر إزاي؟** و **السيرفر ده بيرد
على مين وإزاي؟**

---

## الترتيب

### المشروع من start.spring.io

| | الـ tag | بيضيف إيه |
| --- | --- | --- |
| ١ | `w4-01` | 🟢 المشروع زي ما الموقع عمله بالظبط |
| ٢ | `w4-02` | `server.port` في `application.properties` |

### الطبقات، من تحت لفوق

| | الـ tag | بيضيف إيه |
| --- | --- | --- |
| ٣ | `w4-03` | شكل الـ event: `record` |
| ٤ | `w4-04` | الطبقة اللي تحت: repository شايل الـ list |
| ٥ | `w4-05` | الطبقة اللي في النص: service من غير ولا كلمة HTTP |

### ‏servlet بإيدنا

| | الـ tag | بيضيف إيه |
| --- | --- | --- |
| ٦ | `w4-06` | 🟢 `HelloServlet`: request و response بإيدنا |
| ٧ | `w4-07` | خلصنا منه، فبنمسحه |

### الـ controller فوق الـ service

| | الـ tag | بيضيف إيه |
| --- | --- | --- |
| ٨ | `w4-08` | `@Controller` من غير endpoint، فالرد 404 |
| ٩ | `w4-09` | 🔴 `@GetMapping` على `@Controller` لوحدها: 404 |
| ١٠ | `w4-10` | 🟢 `@ResponseBody`، و JSON |
| ١١ | `w4-11` | `@RestController` = `@Controller` + `@ResponseBody` |
| ١٢ | `w4-12` | `@PathVariable`، والـ `Optional` الفاضي بقى 404 |
| ١٣ | `w4-13` | شكل الطلب الداخل، والـ POST لسه مرفوض 405 |
| ١٤ | `w4-14` | `@PostMapping` و `@RequestBody`، والرد 200 |
| ١٥ | `w4-15` | 🟢 201 و `Location`، ومن غير `Content-Type` يبقى 415 |
| ١٦ | `w4-16` | `@DeleteMapping`، والـ `void` بترد 200 |
| ١٧ | `w4-17` | 🟢 204 No Content، والـ API كامل |

🟢 **وتحت في [الخطوات](#الخطوات) كل واحدة مشروحة ومعاها الناتج.**

---

## تتنقّل بينهم إزاي

الخطوات كلها على فرع `week-04` بالترتيب، وكل واحدة ليها tag.

**تشوف القايمة:**

<div dir="ltr">

```bash
git log --oneline
```

</div>

**تشوف الفرق بين خطوتين،** وده أهم أمر في الريبو ده:

<div dir="ltr">

```bash
git diff w4-14 w4-15
```

</div>

بيوريك **بالظبط** السطور اللي اتغيّرت في الخطوة دي. استخدمه وإنت بتتفرج: كل مرة
توصل لخطوة، بصّ على الـ diff بتاعها الأول وبعدين اكتبها بإيدك.

**تنطّ لخطوة:**

<div dir="ltr">

```bash
git checkout w4-09
```

</div>

**وترجع لآخر حاجة:**

<div dir="ltr">

```bash
git checkout week-04
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

**من IntelliJ:** افتح فولدر `eventia` كمشروع، استنى Maven يخلّص، دوس السهم الأخضر
جنب `main` في `EventiaApplication`.

**ومن الـ terminal:**

<div dir="ltr">

```bash
cd eventia
./mvnw spring-boot:run
```

</div>

السيرفر **مش بيقفل لوحده**. سيبه شغّال، وافتح terminal تاني للـ `curl`. وتقفله بـ
`Ctrl+C`.

⚠️ **على ويندوز:** `./mvnw` في PowerShell أو Git Bash، مش cmd. وأوامر الـ `curl`
اللي فيها JSON اكتبها في **Git Bash**، لأن علامات التنصيص في PowerShell بتتعامل
بشكل مختلف. أو استخدم Postman.

---

## الخطوات

🟢 **الناتج المكتوب تحت متقاس من تشغيل فعلي** لكل خطوة. التواريخ والأوقات (زي
`Started EventiaApplication in 1.5 seconds`) هتختلف عندك، والباقي لأ.

---

# الجزء الأول: المشروع من start.spring.io

### ‏`w4-01` المشروع زي ما الموقع عمله

من start.spring.io: Maven، و Java 21، و Group `com.eventia`، و Artifact `eventia`، و
dependency واحدة: **Spring Web**. ده كل اللي فيه:

<div dir="ltr">

```
eventia/
├── pom.xml
├── mvnw، mvnw.cmd
├── src/main/java/com/eventia/EventiaApplication.java
├── src/main/resources/application.properties
└── src/test/java/com/eventia/EventiaApplicationTests.java
```

</div>

**الـ pom:** رقم نسخة واحد بس، بتاع الـ parent، والـ dependency مالهاش `<version>`:

<div dir="ltr">

```xml
<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>4.1.2</version>
</parent>
...
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>
```

</div>

والسطر ده بيجيب **٣٨ jar** غيره، منهم Tomcat و Jackson. جرّب:

<div dir="ltr">

```bash
./mvnw dependency:tree
```

</div>

**والـ main:**

<div dir="ltr">

```java
@SpringBootApplication
public class EventiaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EventiaApplication.class, args);
    }
}
```

</div>

اعمل Ctrl+Click على `@SpringBootApplication`، هتلاقي جواها تلاتة:

| جواها | عرفناها فين |
| --- | --- |
| `@Configuration` | `AppConfig`، سكشن ٣ |
| `@ComponentScan` | سكشن ٢ |
| `@EnableAutoConfiguration` | دي الجديدة بس |

شغّله:

<div dir="ltr">

```
 :: Spring Boot ::                (v4.1.2)
Tomcat started on port 8080 (http) with context path '/'
Started EventiaApplication in 1.5 seconds
```

</div>

**سيرفر قام، ومحدش نزّل Tomcat.** جه مع الـ starter. ولو عملت:

<div dir="ltr">

```
$ curl -i http://localhost:8080/
HTTP/1.1 404
{"timestamp":"...","status":404,"error":"Not Found","path":"/"}
```

</div>

404، لأن لسه مفيش حاجة ترد.

### ‏`w4-02` `application.properties`

<div dir="ltr">

```properties
spring.application.name=eventia
server.port=8080
```

</div>

الإعداد مكانه ملف مش الكود. غيّر البورت لـ 9090 وشغّل، والسطر في اللوج هيتغيّر.

وهتلاقي ناس كاتبة نفس الكلام في `application.yml`، بالمسافات بدل النقط:

<div dir="ltr">

```yaml
server:
  port: 8080
```

</div>

نفس الحاجة بالظبط، و Boot بتقرا الاتنين. إحنا شغّالين properties.

---

# الجزء التاني: الطبقات، من تحت لفوق

قبل أي endpoint، قررنا كل حاجة هتتكتب فين:

| الطبقة | شغلانتها | بتتغيّر لما |
| --- | --- | --- |
| Controller | HTTP: المسار، والرقم، والـ body | شكل الـ API يتغيّر |
| Service | القواعد | القواعد تتغيّر |
| Repository | التخزين | التخزين يتغيّر |

### ‏`w4-03` شكل الـ event

<div dir="ltr">

```java
public record EventDto(Long id, String title, int capacity, LocalDateTime startsAt) { }
```

</div>

### ‏`w4-04` الـ repository

<div dir="ltr">

```java
@Repository
public class InMemoryEventRepository {

    private final List<EventDto> events = new ArrayList<>();
    private long nextId = 1;

    public List<EventDto> findAll() { ... }
    public Optional<EventDto> findById(Long id) { ... }
    public EventDto save(String title, int capacity, LocalDateTime startsAt) { ... }
    public boolean deleteById(Long id) { ... }
}
```

</div>

- **`ArrayList` وعدّاد `long`:** أبسط حاجة تشيل الداتا. والـ database هتيجي مكانهم
  بعدين.
- **`findById`** for loop عادي بيدوّر على الـ id.
- **الأسامي** `findAll` و `findById` و `save` و `deleteById` نفس أسامي
  ‏`JpaRepository`. لما ييجي الـ database، الملف ده بس اللي هيتغيّر.
- **`Optional`** بدل `null`: اللي بينادي مجبر يتعامل مع «مالقيتش».

### ‏`w4-05` الـ service

<div dir="ltr">

```java
@Service
public class EventService {

    private final InMemoryEventRepository repository;

    public EventService(InMemoryEventRepository repository) {
        this.repository = repository;
    }

    public List<EventDto> findAll() {
        return repository.findAll();
    }

    public Optional<EventDto> findById(Long id) {
        return repository.findById(id);
    }
}
```

</div>

🔴 **دوّر في الملف على `ResponseEntity` أو `HttpStatus`، مش هتلاقي.** الـ service
بتقول «حصل إيه»، والـ controller بيقول «ده معناه إيه في HTTP».

---

# الجزء التالت: servlet بإيدنا

### ‏`w4-06` 🟢 servlet بإيدنا

قبل ما Spring تكتب الكود ده بدالنا، نكتبه مرة بإيدنا.

<div dir="ltr">

```java
public class HelloServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("HelloServlet init, this runs once");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("doGet on thread " + Thread.currentThread().getName());

        String name = request.getParameter("name");
        response.setContentType("text/plain");

        if (name == null) {
            response.setStatus(400);
            response.getWriter().write("name is required");
            return;
        }

        response.setStatus(200);
        response.getWriter().write("Hello, " + name);
    }
}
```

</div>

وفي `EventiaApplication` بنسجّله بـ `@Bean`، زي سكشن ٣: الـ servlet ده، على المسار `/hello`.

<div dir="ltr">

```java
@Bean
public ServletRegistrationBean<HelloServlet> helloServlet() {
    return new ServletRegistrationBean<>(new HelloServlet(), "/hello");
}
```

</div>

<div dir="ltr">

```
$ curl http://localhost:8080/hello?name=Ahmed     → Hello, Ahmed       HTTP 200
$ curl http://localhost:8080/hello                → name is required   HTTP 400
$ curl -X POST http://localhost:8080/hello        → HTTP 405
```

</div>

**وبص على الـ console:**

<div dir="ltr">

```
HelloServlet init, this runs once
doGet on thread http-nio-8080-exec-1
doGet on thread http-nio-8080-exec-2
doGet on thread http-nio-8080-exec-6
```

</div>

- **`init` مرة واحدة:** Tomcat عمل object واحد بس من الـ servlet.
- **كل طلب على thread مختلف:** object واحد بيخدم كل الناس في نفس الوقت. فأي field فيه
  مشترك.
- **الـ 405:** ماكتبناش `doPost`، فـ `HttpServlet` ردت لوحدها.

### ‏`w4-07` نمسح الـ servlet

خلصنا من الـ servlet، فبنمسحه قبل ما نكتب الـ controller، عشان نبدأ على مشروع نضيف. اتشال هو والـ
`@Bean` بتاعه، و `/hello` بقت ترد 404.

<div dir="ltr">

```
$ curl http://localhost:8080/hello?name=Ahmed
{"timestamp":"...","status":404,"error":"Not Found","path":"/hello"}
```

</div>

🟢 **وافتكر:** الـ controller مش بديل للـ servlet. هو شغّال جوّه servlet اسمها
`DispatcherServlet`، بتورث من `HttpServlet` زي `HelloServlet` بالظبط. Spring كتبتها
مرة واحدة بدالك.

# الجزء الرابع: الـ controller فوق الـ service

### ‏`w4-08` `@Controller` من غير endpoint

<div dir="ltr">

```java
@Controller
@RequestMapping("/api/events")
public class EventController {

    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }
}
```

</div>

‏`curl /api/events` بيرد 404، لأن مفيش ولا method.

### ‏`w4-09` 🔴 أول endpoint، والرد 404

<div dir="ltr">

```java
@GetMapping
public List<EventDto> findAll() {
    return service.findAll();
}
```

</div>

<div dir="ltr">

```
$ curl http://localhost:8080/api/events
{"timestamp":"...","status":404,"error":"Not Found","path":"/api/events"}
```

</div>

الـ method موجودة والمسار صح، ومع ذلك 404. ليه؟ **`@Controller` لوحدها معمولة للمواقع
اللي بترجّع صفحات.** فـ Spring فكّرت إن اللي رجّعناه اسم صفحة، ودوّرت على صفحة اسمها
`api/events`، ومالقيتهاش.

### ‏`w4-10` 🟢 `@ResponseBody`

<div dir="ltr">

```java
@GetMapping
@ResponseBody
public List<EventDto> findAll() {
    return service.findAll();
}
```

</div>

<div dir="ltr">

```
$ curl http://localhost:8080/api/events
[{"id":1,"title":"Spring Boot Workshop","capacity":40,"startsAt":"2026-11-05T08:15:11.0244691"},
 {"id":2,"title":"Docker for Beginners","capacity":25,"startsAt":"2026-11-12T08:15:11.0244691"}]
```

</div>

‏`@ResponseBody` بتقول لـ Spring: **اللي بترجّعه هو الرد نفسه**، مش اسم صفحة. و Jackson
بتحوّله JSON.

### ‏`w4-11` `@RestController`

<div dir="ltr">

```java
@RestController
@RequestMapping("/api/events")
public class EventController {

    @GetMapping
    public List<EventDto> findAll() {
        return service.findAll();
    }
}
```

</div>

نفس الرد بالظبط. اعمل Ctrl+Click على `@RestController`، هتلاقي جواها:

<div dir="ltr">

```java
@Controller
@ResponseBody
public @interface RestController { ... }
```

</div>

| | `@Controller` | `@RestController` |
| --- | --- | --- |
| الـ method بترجّع | اسم صفحة | الداتا نفسها |
| Spring بتبعت | صفحة HTML | JSON |
| معمولة لـ | مواقع | APIs، زي بتاعنا |

### ‏`w4-12` `@PathVariable` و 404

<div dir="ltr">

```java
@GetMapping("/{id}")
public ResponseEntity<EventDto> findById(@PathVariable Long id) {
    Optional<EventDto> event = service.findById(id);
    if (event.isPresent()) {
        return ResponseEntity.ok(event.get());
    }
    return ResponseEntity.notFound().build();
}
```

</div>

<div dir="ltr">

```
$ curl -i http://localhost:8080/api/events/1     → 200
$ curl -i http://localhost:8080/api/events/99    → 404
$ curl -i http://localhost:8080/api/events/abc   → 400
```

</div>

الـ service رجّعت `Optional`، والـ controller هو اللي ترجمه: لقيت يبقى 200،
مالقيتش يبقى 404. و `abc` مش رقم، فالتحويل فشل قبل ما الكود بتاعنا يتنادى، والرد 400.

### ‏`w4-13` شكل الطلب الداخل

<div dir="ltr">

```java
public record CreateEventRequest(String title, int capacity, LocalDateTime startsAt) { }
```

</div>

من غير `id`، لأن الـ id إحنا اللي بنولّده.

<div dir="ltr">

```
$ curl -H "Content-Type: application/json" -d '{"title":"Intro to Redis","capacity":30,"startsAt":"2026-11-01T18:00:00"}' http://localhost:8080/api/events
{"timestamp":"...","status":405,"error":"Method Not Allowed","path":"/api/events"}
```

</div>

**405:** المسار موجود، بس مع GET بس.

### ‏`w4-14` `@PostMapping`

في الـ service:

<div dir="ltr">

```java
public EventDto create(CreateEventRequest request) {
    return repository.save(request.title(), request.capacity(), request.startsAt());
}
```

</div>

وفي الـ controller:

<div dir="ltr">

```java
@PostMapping
public EventDto create(@RequestBody CreateEventRequest request) {
    return service.create(request);
}
```

</div>

<div dir="ltr">

```
{"id":3,"title":"Intro to Redis","capacity":30,"startsAt":"2026-11-01T18:00:00"}
HTTP 200
```

</div>

‏`@RequestBody` بتاخد الـ JSON وتحوّله object. بس الرد 200، والصح...

### ‏`w4-15` 🟢 201 و `Location`

<div dir="ltr">

```java
@PostMapping
public ResponseEntity<EventDto> create(@RequestBody CreateEventRequest request) {
    EventDto created = service.create(request);
    return ResponseEntity
            .created(URI.create("/api/events/" + created.id()))
            .body(created);
}
```

</div>

<div dir="ltr">

```
$ curl -i -H "Content-Type: application/json" -d '{...}' http://localhost:8080/api/events
HTTP/1.1 201
Location: /api/events/3
Content-Type: application/json

{"id":3,"title":"Intro to Redis","capacity":30,"startsAt":"2026-11-01T18:00:00"}
```

</div>

**ومن غير `-H "Content-Type: application/json"`:**

<div dir="ltr">

```
{"timestamp":"...","status":415,"error":"Unsupported Media Type","path":"/api/events"}
```

</div>

السيرفر مش عارف إن الـ body ده JSON.

🔴 **وخد بالك إن ده اتغيّر في الـ controller بس.** الـ service ماتعرفش حاجة عن 201.

### ‏`w4-16` `@DeleteMapping`

<div dir="ltr">

```java
@DeleteMapping("/{id}")
public void delete(@PathVariable Long id) {
    service.delete(id);
}
```

</div>

<div dir="ltr">

```
$ curl -i -X DELETE http://localhost:8080/api/events/2
HTTP 200
```

</div>

الـ `void` لوحدها بترد 200. بس مفيش body، فالأصح...

### ‏`w4-17` 🟢 204

<div dir="ltr">

```java
@DeleteMapping("/{id}")
@ResponseStatus(HttpStatus.NO_CONTENT)
public void delete(@PathVariable Long id) {
    service.delete(id);
}
```

</div>

<div dir="ltr">

```
HTTP 204
```

</div>

ولو مسحت حاجة مش موجودة، برضه 204. تمسحها مرة ولا عشرة، النتيجة واحدة، ودي اسمها
**idempotency**.

---

---

## الأرقام اللي شفناها

| الكود | معناه | جه من |
| --- | --- | --- |
| 200 | تمام | GET |
| 201 | اتعمل حاجة جديدة | POST |
| 204 | تمام، ومفيش body | DELETE |
| 400 | الطلب غلط | `/api/events/abc` |
| 404 | مش موجود | `/api/events/99` |
| 405 | المسار موجود، الـ method لأ | POST على `w4-13` |
| 415 | نوع الـ body مش مفهوم | POST من غير `Content-Type` |

---

## جرّب تكسره بنفسك

ابدأ من آخر الفرع، وبعد كل تجربة رجّع بـ `git checkout -- .`

| اعمل إيه | هتشوف إيه |
| --- | --- |
| انقل `EventiaApplication` لـ `com.eventia.app` | التطبيق **بيقوم عادي**، بس كل طلب بيرد 404. الـ scan مالقاش ولا controller |
| ابعت event عنوانها `""` و capacity `-5` | **201**، اتقبلت. ودي مشكلة الأسبوع الجاي |
| POST، اقفل التطبيق، شغّله، GET | الـ event راحت. الداتا في الـ memory |

---

## تذاكر منين

الكتاب **Spring Start Here** لـ Laurentiu Spilca، والمؤلف نفسه شارحه فصل فصل:

| | |
| --- | --- |
| البلاي ليست | https://youtube.com/playlist?list=PLEocw3gLFc8W25hvuYb6EERd3F0aZjUQF |
| الفصل ٧: Spring Boot و Spring MVC | https://www.youtube.com/watch?v=abr4bdK9Z_4 و https://www.youtube.com/watch?v=sJf_otREa04 |
| الفصل ٨: Web apps | https://www.youtube.com/watch?v=xR77mF4IIpQ |
| الفصل ١٠: REST | https://www.youtube.com/watch?v=C6H1YWl-GzY |

🔴 **الـ HTTP نفسه مش في الكتاب.** اقراه من هنا:
https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview

---

## الأسبوع الجاي

الـ API بيقبل event من غير عنوان، وعدد أماكنها سالب.

الأسبوع الجاي **Validation و Error Handling**: الـ API يرفض البيانات الغلط، برسالة
محترمة ورقم صح.

---

‏Eng. Mohamed Shehab

</div>
