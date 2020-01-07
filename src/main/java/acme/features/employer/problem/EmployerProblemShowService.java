
package acme.features.employer.problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.problems.Problem;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerProblemShowService implements AbstractShowService<Employer, Problem> {

	// Internal state -------------------------------------------------------------

	@Autowired
	EmployerProblemRepository repository;


	// AbstractShowService<Employer, Problem> interface -------------------------------

	@Override
	public boolean authorise(final Request<Problem> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Problem> request, final Problem entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "hint");
	}

	@Override
	public Problem findOne(final Request<Problem> request) {
		assert request != null;

		Problem result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneProblemById(id);

		return result;
	}

}
