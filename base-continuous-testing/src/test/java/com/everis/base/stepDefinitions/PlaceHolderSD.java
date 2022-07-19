package com.everis.base.stepDefinitions;

import com.everis.base.steps.NetflixSteps;
import com.everis.base.steps.PlaceHolderSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PlaceHolderSD {

    @Steps
    public PlaceHolderSteps placeHolder;

    @Given("que la aplicación está operativa")
    public void que_la_aplicación_está_operativa() {
        System.out.println("--------------El servicio está operativo---------");
    }

    @When("consulto la lista de artículos")
    public void consulto_la_lista_de_artículos() {
        System.out.println("La lista de artículos ha sido consultada");
        placeHolder.listPosts();
    }
    @Then("se valida que el código es {int}")
    public void se_valida_que_el_código_es(int i) {
        placeHolder.validateStatusCode(i);
    }
    @And("se me mostrará en consola la lista de artículos existentes")
    public void se_me_mostrará_en_consola_la_lista_de_artículos_existentes() {
        placeHolder.printList();
    }
}
