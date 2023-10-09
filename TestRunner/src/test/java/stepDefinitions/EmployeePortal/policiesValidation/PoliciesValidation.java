package stepDefinitions.EmployeePortal.policiesValidation;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageFactory.employeePortal.employeePolicies.Policies;
import stepDefinitions.BrowserHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PoliciesValidation {

    Policies policies;
    @Given("the user Clicked on the Policies Component")
    public void the_user_clicked_on_the_policies_component() {
        policies=new Policies(BrowserHelper.getDriverName());
        policies.policiesModule();
    }
    @When("user click on the Add policy button")
    public void user_click_on_the_add_policy_button() {
        policies=new Policies(BrowserHelper.getDriverName());
        policies.addPolicyButtons();

    }

    @When("user chose the file {string} to add as policy")
    public void user_chose_the_file_to_add_as_policy(String file) {
        policies=new Policies(BrowserHelper.getDriverName());
        policies.getFile(file);
    }

    @When("user enter {string} as new policy name")
    public void user_enter_as_new_policy_name(String policyName){
        policies=new Policies(BrowserHelper.getDriverName());
        policies.getName(policyName);

    }

    @When("user click on the Add policy button on the popPup")
    public void user_click_on_the_add_policy_button_on_the_pop_pup(){
        policies=new Policies(BrowserHelper.getDriverName());
        policies.policyPopPupButton();
    }

    @Then("policy {string} should be added")
    public void policy_should_be_added(String policyName) {
        policies=new Policies(BrowserHelper.getDriverName());
        boolean status=policies.addedPolicyName(policyName);
        Assert.assertTrue(status);

    }

    @Then("Validate the total added role in policies dashboard")
    public void validate_the_total_added_role_in_policies_dashboard() {
        policies=new Policies(BrowserHelper.getDriverName());
        List<Map<String, Object>> apiAllPolicies= policies.getTotalPoliciesApi();
        List<String> uiPolicies= policies.totalPolicies();
        List<String> policyNames = new ArrayList<>();
        for (Map<String, Object> policy : apiAllPolicies) {
            if (policy.containsKey("policy_name")) {
                Object policyName = policy.get("policy_name");
                if (policyName != null) {
                    policyNames.add(policyName.toString());
                }
            }
        }
      Assert.assertEquals(policyNames, uiPolicies);

    }

    @When("user click on the Edit Policy icon")
    public void user_click_on_the_Edit_Policy_icon() {
        policies=new Policies(BrowserHelper.getDriverName());
        policies.editPolicyIcon();

    }

    @When("user chose the file {string} to edit as policy")
    public void user_chose_the_file_to_edit_as_policy(String file) {
        policies=new Policies(BrowserHelper.getDriverName());
        policies.getEditFile(file);
    }

    @When("user enter {string} as edited policy name")
    public void user_enter_as_edited_policy_name(String name) {
        policies=new Policies(BrowserHelper.getDriverName());
        policies.getEditedPolicyName(name);
    }

    @When("user click on the edit policy button on the popPup")
    public void user_click_on_the_edit_policy_button_on_the_pop_pup() {
        policies=new Policies(BrowserHelper.getDriverName());
        policies.editPolicyButton();
    }

    @When("user inspect all Svg icon in each row of the table policies dashboard")
    public void user_inspect_all_Svg_icon_in_each_row_of_the_table_policies_dashboard() {
        policies=new Policies(BrowserHelper.getDriverName());
    Assert.assertTrue(policies.lookAtEachTableRow());
    }


}
