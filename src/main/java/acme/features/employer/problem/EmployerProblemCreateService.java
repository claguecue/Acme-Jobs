
package acme.features.employer.problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.problems.Problem;
import acme.entities.roles.Employer;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractCreateService;

@Service
public class EmployerProblemCreateService implements AbstractCreateService<Employer, Problem> {

	// Internal state --------------------------------------------------------------------------

	@Autowired
	EmployerProblemRepository repository;


	// AbstractCreateService<Employer, Problem> interface ---------------------------------------

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

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<Problem> request, final Problem entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "hint");
		model.setAttribute("id", entity.getJob().getId());
	}

	@Override
	public Problem instantiate(final Request<Problem> request) {
		Problem result;
		Job job;
		int idJob;

		result = new Problem();
		idJob = request.getModel().getInteger("id");
		job = this.repository.findJobForThisProblem(idJob);

		if (job != null) {
			result.setJob(job);
		}

		return result;
	}

	@Override
	public void validate(final Request<Problem> request, final Problem entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void create(final Request<Problem> request, final Problem entity) {
		this.repository.save(entity);
	}

}
