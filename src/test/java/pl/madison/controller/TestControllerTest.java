package pl.madison.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.madison.dao.KlientDao;
import pl.madison.domain.Klient;
import pl.madison.services.IKlientServices;
import pl.madison.services.KlientServicesImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class TestControllerTest {

    @InjectMocks
    private TestController testController;

    @Mock
    private IKlientServices iKlientServices;

    private MockMvc mockMvc;

    @Before
    public void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }

    @org.junit.Test
    public void check_wyswietl() throws Exception {
        List<Klient> klients = Arrays.asList(Klient.builder().nazwisko("kkk").build());
        when(iKlientServices.findAll()).thenReturn(klients);
        mockMvc.perform(get("/wyswietl")).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nazwisko").value("kkk"));
    }

    @org.junit.Test
    public void srednia() throws Exception {
    }

    @org.junit.Test
    public void update() throws Exception {
        when(iKlientServices.findOne(2L)).thenReturn(Klient.builder().id(2L).rachunek(30.0).build());
        mockMvc.perform(MockMvcRequestBuilders.put("/update").param("id","2")
                .param("rachunek", "30.0")).andExpect(MockMvcResultMatchers.content()
                .string("Udalo Ci sie poprawic Rachunek :)"));
    }

    @org.junit.Test
    public void delete() throws Exception {
        when(iKlientServices.findOne(1L)).thenReturn(Klient.builder().id(1L).build());
        mockMvc.perform(MockMvcRequestBuilders.delete("/delete")
                .param("id","1")).andExpect(MockMvcResultMatchers.content()
                .string("Usunales klienta i jego rachunek"));
    }

    @org.junit.Test
    public void dodaj() throws Exception {
        when(iKlientServices.save(Klient.builder().nazwisko("bbb")
                .rachunek(400).build())).thenReturn(Klient.builder().id(1L).build());
        mockMvc.perform(MockMvcRequestBuilders.put("/dodaj")
                .param("id","1")
                .param("nazwisko", "bbb")
                .param("rachunek", "400"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("Jupi kolejny klient zaplacil :)"));
    }

}