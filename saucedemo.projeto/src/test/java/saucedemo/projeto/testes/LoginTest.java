package saucedemo.projeto.testes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import projetosaucedemo.pages.LoginPage;
import saucedemo.projeto.elementos.Elementos;
import saucedemo.projeto.metodos.Metodos;
import saucedemo.projeto.navegadores.Navegador;

public class LoginTest extends Navegador{
	
	
	Elementos elemento = new Elementos();
	LoginPage login = new LoginPage();
	
	String usuario = "standart_user";
	String senha = "secret_sauce";
	String usuarioInvalido = "userInvalido";
	String senhaInvalida = "";
	String usuarioBloqueado = "locked_out_user";
	
	@Before
	public void inicioTeste() {
		Navegador.abrirNavegador();
	}
	@After
	public void fecharTeste() {
		Navegador.fecharNavegador();		
}
	@Test
	public void loginValido() {
	login.realizarLogin(usuario, senha);
	  Metodos.takeScreenshot(driver,"screenshot_loginSucesso.png");
 
	}
	@Test
	public void loginUsuarioInvalido() {
		login.realizarLogin(usuario, senha);
	    Metodos.takeScreenshot(driver,"screenshot_loginInavalido.png");
	    Metodos.validarmsg(elemento.msgErro,
	    		"Epic sadface: Username and password do not match any user in this service");
}
	@Test
	public void loginUsuarioEmBranco() {
		login.realizarLogin("","");
		Metodos.takeScreenshot(driver,"screenshot_loginUsuarioEmBranco.png");
		 Metodos.validarmsg(elemento.msgErro, "Epic sadface: Username is required");
	}

	@Test
	public void loginUsuarioBloqueado() {
		
		login.realizarLogin(usuarioBloqueado, senha);
        Metodos.takeScreenshot(driver, "screenshot_loginBloqueado.png");
		Metodos.validarmsg(elemento.msgErro, "Epic sadface: Sorry, this user has been locked out.");
	}
	}
	





