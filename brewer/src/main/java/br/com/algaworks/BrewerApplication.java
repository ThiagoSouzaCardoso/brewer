package br.com.algaworks;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import br.com.algaworks.brewer.storage.FotoStorage;
import br.com.algaworks.brewer.storage.local.FotoStorageLocal;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
@EnableTransactionManagement
public class BrewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrewerApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

	@Bean
	public FotoStorage fotoStorageLocal(){
		return new FotoStorageLocal();
	}
	
	
}