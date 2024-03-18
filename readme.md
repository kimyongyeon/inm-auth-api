# 초기화
./gradlew clean

# 빌드
./gradlew build

# 실행
./gradlew bootRun

# 패키지 구조
FO API 프로젝트 패키지 구조는 하나에 서비스에서 하나의 기능만 하기 때문에 계층구조로 정의한다. 
- innim.fo.api.biz : 비즈니스 도메인 및 로직 
    - restController : UI 진입 오브젝트 
    - domain : 도메인 규칙 관련 패키지 
      - model : 도메인 모델 정의 
      - consts : 도메인 상수 정의
      - exception : 도메인 예외 정의
      - persistence : 도메인 영속성 정의
      - service : 도메인 서비스 정의
      - usecase : 도메인 유스케이스 정의
    - dto : 웹으로 들어오거나 나갈때 사용하는 오브젝트 
- innim.fo.api.sys : 시스템 도메인 및 로직
    - common : 시스템 공통 패키지
      - ApiResponse : API 응답 오브젝트
      - BizControllerAdvice : 비즈니스 컨트롤러 어드바이스
      - ErrorCode : 에러 코드 정의
      - SuccessCode : 성공 코드 정의
    - config : 시스템 설정 패키지
      - DataSourceConfig : 데이터소스 설정

# 데이터소스 정의
- 로컬 : H2 사용한다. 
- 개발 : postgresql 사용한다.
- 구성
  - 마스터/슬래이브 구성 
  - 마스터 : 쓰기 전용
  - 슬래이브 : 읽기 전용

# 마이바티스 구성 
- 모델값은 카멜케이스로 매핑 되도록 정의 
- 글로벌 캐싱 미사용 
- 마이바티스 구성은 자바파일로 구성함. 

# logback 구성 
- 로그 사용을 위해서는 아래와 같으 설정 하고 사용하면 된다. 
- SQL FORMAT은 설정되어 있다. 
```java
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SampleSecondService implements SampleSecondUseCase {

    private final SampleSecondMapper<ReqSampleSecondModel, ResSampleSecondModel> sampleSecondMapper;

    @Override
    public ResSampleSecondDto getSampleSecond(long id) {
        ResSampleSecondModel byId = sampleSecondMapper.findById(id);
        
        log.debug("byId: {}", byId);
        
        return ResSampleSecondDto.fromMapperModel(byId);
    }
}

```