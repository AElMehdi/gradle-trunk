package backend;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    @Test
    void init_spring_boot() {
        App app = new App();

        assertThat(app).isNotNull();
    }
}
