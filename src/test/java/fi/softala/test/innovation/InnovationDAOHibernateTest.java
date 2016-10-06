package fi.softala.test.innovation;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import fi.softala.vote.controller.MainCtrl;
import fi.softala.vote.dao.InnovationDAO;
import fi.softala.vote.dao.InnoDAOHibernateImpl;
import fi.softala.vote.model.*;

@RunWith(MockitoJUnitRunner.class)
public class InnovationDAOHibernateTest {
	
	@Inject
	private MockMvc mockMvc;
	@InjectMocks
	private MainCtrl controller;
	@Mock
	private InnovationDAO mockDao;
	
	@Before
	public void setup() {

		//controller unders
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();

		//configure the return values of the mock object 
		Mockito.when(mockDao.addNew(new Innovation())).thenReturn(new Innovation());
		Mockito.when(mockDao.find(1)).thenReturn(new Innovation());
		Mockito.when(mockDao.findAll()).thenReturn(new ArrayList<Innovation>());
	}
	
	@Test
	public void testAddNew() throws Exception {
		Innovation mockInno = new Innovation();
		Team mockTeam = new Team();
		
		mockTeam.setTeamName("uusi tiimi");
		mockInno.setInnoName("uusi nimi");
		mockInno.setInnoDesc("uusi kuvaus");
		mockInno.setTeam(mockTeam);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/new"); //placeholder
		mockMvc.perform(requestBuilder)
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.model().size(1))
		.andExpect(MockMvcResultMatchers.view().name("/index")); //placeholder
		
		verify(mockDao, times(1)).addNew(mockInno);
	}
	
	@Test
	public void testFind() throws Exception {
		//create a request
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/find");

		//check status, model size and view name
		mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.model().size(1))
				.andExpect(MockMvcResultMatchers.view().name("/index"));
		//verify that the mock has been called
		verify(mockDao, times(1)).find(1);
	}
	
	@Test
	public void testFindAll() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/findAll");

		//check status, model size and view name
		mockMvc.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.model().size(1))
				.andExpect(MockMvcResultMatchers.view().name("/index"));
		//verify that the mock has been called
		verify(mockDao, times(1)).findAll();
	}
}
