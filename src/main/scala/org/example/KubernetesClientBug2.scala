package org.example

import cats.effect.IO
import com.goyeau.kubernetes.client.KubernetesClient

object KubernetesClientBug2 extends App {
  def method(client: KubernetesClient[IO]): IO[Unit] = {
    client
      .configMaps
      .namespace("")
      .watch()
      .evalTap {
        case Left(_) => IO(())
        case Right(_) => IO(())
      }
      .compile
      .drain
  }
}
