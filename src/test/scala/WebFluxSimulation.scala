import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder

class WebFluxSimulation extends Simulation {

  val httpProtocolBuilder: HttpProtocolBuilder = http.baseURL("http://localhost:8080/api/user/")

  val scenarioBuilder: ScenarioBuilder = scenario("WebFluxSimulation").exec(http("webflux").get("webflux/1000"))

  setUp(scenarioBuilder.inject(rampUsers(1000).over(10))).protocols(httpProtocolBuilder)
}
