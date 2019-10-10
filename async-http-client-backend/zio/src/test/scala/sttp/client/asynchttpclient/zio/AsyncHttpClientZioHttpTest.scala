package sttp.client.asynchttpclient.zio

import sttp.client.{NothingT, SttpBackend}
import sttp.client.impl.zio._
import sttp.client.testing.{ConvertToFuture, HttpTest}
import zio.Task

class AsyncHttpClientZioHttpTest extends HttpTest[Task] {

  override implicit val backend: SttpBackend[Task, Nothing, NothingT] =
    runtime.unsafeRunSync(AsyncHttpClientZioBackend()).getOrElse(c => throw c.squash)
  override implicit val convertToFuture: ConvertToFuture[Task] = convertZioIoToFuture
}
