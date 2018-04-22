package crud

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class crud extends Simulation {

	val httpProtocol = http
		.baseURL("http://18.208.84.33")
		.inferHtmlResources()
		.acceptHeader("application/json, text/plain, */*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:59.0) Gecko/20100101 Firefox/59.0")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"X-CSRF-TOKEN" -> "ha5yR6QpI86A3VRI5JRW4vUJxNhxFom4tAGV5Ift",
		"X-Requested-With" -> "XMLHttpRequest",
		"X-XSRF-TOKEN" -> "eyJpdiI6ImZpQVwvc0t2cGFielNZenRDenlkXC9iQT09IiwidmFsdWUiOiJ0QUlsKzQ4eUhqTW1DTUF3N2FXbXZoc1A4Wm9wZldYK2VpdVlNcTB0MCtWZmFpWUtuSHphcWZnVWpraU0rd1wvc29WYzF5bldlYTRzZ0VTSWFLUERnOXc9PSIsIm1hYyI6IjIxOGQ1MjU3MWM1YmY3NDZhYTA0ZWYxZTE4MmI1OGJjZjZmMDk4MWNhNDRmNDliZDMxNmYwN2RkZjkwMTJiNzkifQ==")

	val headers_2 = Map("Accept" -> "*/*")

	val headers_3 = Map("Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")

	val headers_5 = Map(
		"Content-Type" -> "application/json;charset=utf-8",
		"X-CSRF-TOKEN" -> "ha5yR6QpI86A3VRI5JRW4vUJxNhxFom4tAGV5Ift",
		"X-Requested-With" -> "XMLHttpRequest",
		"X-XSRF-TOKEN" -> "eyJpdiI6ImZpQVwvc0t2cGFielNZenRDenlkXC9iQT09IiwidmFsdWUiOiJ0QUlsKzQ4eUhqTW1DTUF3N2FXbXZoc1A4Wm9wZldYK2VpdVlNcTB0MCtWZmFpWUtuSHphcWZnVWpraU0rd1wvc29WYzF5bldlYTRzZ0VTSWFLUERnOXc9PSIsIm1hYyI6IjIxOGQ1MjU3MWM1YmY3NDZhYTA0ZWYxZTE4MmI1OGJjZjZmMDk4MWNhNDRmNDliZDMxNmYwN2RkZjkwMTJiNzkifQ==")



	val scn = scenario("crud")
		.exec(http("request_0")
			.get("/companies")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/api/v1/companies")
			.headers(headers_1),
            http("request_2")
			.get("/favicon.ico")
			.headers(headers_2),
            http("request_3")
			.get("/favicon.ico")
			.headers(headers_3)))
		.exec(http("request_4")
			.get("/api/v1/companies/2")
			.headers(headers_1))
		.exec(http("request_5")
			.patch("/api/v1/companies/2")
			.headers(headers_5)
			.body(RawFileBody("crud_0005_request.txt"))
			.resources(http("request_6")
			.get("/api/v1/companies")
			.headers(headers_1)))
		.exec(http("request_7")
			.post("/api/v1/companies")
			.headers(headers_5)
			.body(RawFileBody("crud_0007_request.txt"))
			.resources(http("request_8")
			.get("/api/v1/companies")
			.headers(headers_1)))

	setUp(scn.inject(atOnceUsers(50))).protocols(httpProtocol)
}