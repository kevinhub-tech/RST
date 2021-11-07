package lithan.rst.project.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lithan.rst.project.carportal.config.JPAConfig;
import lithan.rst.project.carportal.config.SecurityConfig;
import lithan.rst.project.carportal.config.WebMvcConfig;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={WebMvcConfig.class, JPAConfig.class, SecurityConfig.class})
@WebAppConfiguration
public class AppTest {
	
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }

    @Test
    @WithMockUser(username = "admin", roles={"Administrator"})
    public void testGetCars() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/cars"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles={"Users"})
    public void testAddCar() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                                    .post("/cars")
                                    .param("make", "Audi")
                                    .param("model", "2008")
                                    .param("registeration", "2009")
                                    .param("price", "$50000")
                                    .with(csrf()))
                    .andDo(print()).andExpect(status().isOk());
    }

    
    /*@Test
    @WithMockUser(username = "admin", roles={"Administrator"})
    public void testAddCarWithNoPermission() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/cars")
                .param("make", "China")
                .param("model", "2010")
                .param("registeration", "2008")
                .param("price", "50000")
                .with(csrf()))
                .andDo(print()).andExpect(status().is4xxClientError());
    }*/
}