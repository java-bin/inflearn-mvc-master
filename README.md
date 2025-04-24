# 정수원의 강의 - 스프링 웹 MVC 완전정복

## model 1
- jsp에 모든 코드
## model 2 (mvc)
- model (java bean) : 비즈니스 로직
- view (jsp)
- controller (servlet)
## front controller?
- front controller : 공통기능 처리
- controller
- jsp
## spring mvc
- front controller (spring 내부적으로 있음)
- controller
- jsp
- application.properties에 설정 필요

## Servlet
- Servlet : 최상위 인터페이스
- GenericServlet
- HttpServlet : Http 요청 처리를 위한 추상 클래스
  - doGet, doPost, doPut, doDelete (HttpServletRequest, HttpServletResponse)
- 생명주기 : 서블릿 컨테이너에 의해 로드 및 생성 -> init, service, destroy 과정
  - init() : 초기화 작업 (최초 1번)
  - service() : 요청 처리 작업 (클라이언트로부터 오는 모든 요청 -> http Method)
  - destroy() : 종료 작업 (리소스 해제)