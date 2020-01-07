
package acme.features.employer.problem;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.problems.Problem;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractListService;

@Service
public class EmployerProblemListService implements AbstractListService<Employer, Problem> {

	// Internal state ---------------------------------------------------------------

	@Autowired
	EmployerProblemRepository repository;


	// AbstractListService<Employer, Problem> interface ---------------------------------

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

		request.unbind(entity, model, "text", "hint", "job");
	}

	@Override
	public Collection<Problem> findMany(final Request<Problem> request) {
		assert request != null;

		Collection<Problem> result;
		int jobId;

		String[] cadena = request.getServletRequest().getQueryString().trim().split("=");
		jobId = Integer.parseInt(cadena[1]);

		result = this.repository.findManyByJobId(jobId);

		return result;
	}

}