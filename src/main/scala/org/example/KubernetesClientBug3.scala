package org.example

import cats.effect.IO
import com.goyeau.kubernetes.client.KubernetesClient
import io.k8s.api.core.v1.ConfigMap

object KubernetesClientBug3 extends App {
  def method(client: KubernetesClient[IO]): IO[ConfigMap] = {
    client.configMaps.namespace("").get("")
  }
}
