package io.alpenglow.digitalocean;

import com.pulumi.Pulumi;
import com.pulumi.digitalocean.Project;
import com.pulumi.digitalocean.ProjectArgs;

enum Namespace implements Main {}

public sealed interface Main {

  static void main(String... args) {
    Pulumi.run(digitalOcean -> {
      final var project = new Project("alpenglow",
        ProjectArgs.builder()
          .name("alpenglow")
          .description("The Alpenglow project")
          .build()
      );

      digitalOcean.export("projectName", project.name());
    });
  }
}
