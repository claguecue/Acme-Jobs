
package acme.features.employer.problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.problems.Problem;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class EmployerProblemUpdateService implements AbstractUpdateService<Employer, Problem> {

	// Internal state --------------------------------------------------------------------------

	@Autowired
	EmployerProblemRepository repository;


	// AbstractUpdateService<Employer, Problem> interface ---------------------------------------

	@Override
	public boolean authorise(final Request<Problem> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<Problem> request, final Problem entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "job");
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

	@Override
	public void validate(final Request<Problem> request, final Problem entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void update(final Request<Problem> request, final Problem entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
