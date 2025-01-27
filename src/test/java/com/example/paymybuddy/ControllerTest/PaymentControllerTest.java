package com.example.paymybuddy.ControllerTest;

import com.example.paymybuddy.controller.PaymentController;
import com.example.paymybuddy.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PaymentController.class)
@AutoConfigureMockMvc(addFilters = false)
public class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PaymentService paymentService;

    @Test
    public void testMakePayment() throws Exception {
        // Données pour le test
        Long senderId = 1L;
        Long receiverId = 2L;
        double amount = 100.0;

        // Simulation du comportement du service
        Mockito.doNothing().when(paymentService).makePayment(senderId, receiverId, amount);

        // Exécution de la requête HTTP POST
        mockMvc.perform(post("/api/v1/transfer")
                        .param("senderId", senderId.toString())
                        .param("receiverId", receiverId.toString())
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk());

        // Vérification que le service a été appelé avec les bons paramètres
        Mockito.verify(paymentService).makePayment(senderId, receiverId, amount);
    }
}
