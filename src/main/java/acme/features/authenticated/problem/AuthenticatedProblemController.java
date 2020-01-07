
package acme.features.authenticated.problem;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.problems.Problem;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/authenticated/problem/")
public class AuthenticatedProblemController extends AbstractController<Authenticated, Problem> {

	// Internal state ------------------------------------------------------------------

	@Autowired
	private AuthenticatedProblemShowService	showService;

	@Autowired
	private AuthenticatedProblemListService	listService;


	// Constructors --------------------------------------------------------------------

	@PostConstruct
	private void initialisate() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);

	}

}
