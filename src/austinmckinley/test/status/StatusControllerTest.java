package austinmckinley.test.status;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.MockitoAnnotations.initMocks;

import org.springframework.test.web.servlet.MockMvc;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import austinmckinley.pitboss.status.StatusController;


public class StatusControllerTest {

	MockMvc mockMvc;
	@InjectMocks StatusController controller;
	
	@Before
	public void setup() {
		initMocks(this);
		mockMvc = standaloneSetup(controller).build();
	}
	
	@Test
	public void testGetIndex() throws Exception {
		mockMvc.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(view().name("/status-index"));
	}
}
