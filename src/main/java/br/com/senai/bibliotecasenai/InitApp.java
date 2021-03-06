package br.com.senai.bibliotecasenai;

import java.awt.EventQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import br.com.senai.bibliotecasenai.view.TelaConsultaEstudante;

@SpringBootApplication
public class InitApp {
	
	@Autowired
	private TelaConsultaEstudante telaLogin;
	
	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(InitApp.class);
		builder.headless(false);
		builder.run(args);
	}
	
	@Bean	
	public CommandLineRunner commandLineRunner(ApplicationContext ac) {
		return args -> {
			try {				
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {							
							telaLogin.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
			}catch (Exception e) {				
				e.printStackTrace();
			}
			
		};
	}

}
