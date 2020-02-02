
package acme.features.employer.orem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Job;
import acme.entities.orems.Orem;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerOremShowService implements AbstractShowService<Employer, Orem> {

	// Internal state -------------------------------------------------------------

	@Autowired
	EmployerOremRepository repository;


	// AbstractShowService<Employer, Orem> interface -------------------------------

	@Override
	public boolean authorise(final Request<Orem> request) {
		assert request != null;

		boolean result;
		int oremId;
		Orem orem;
		Job job;
		Employer employer;
		Principal principal;

		oremId = request.getModel().getInteger("id");
		orem = this.repository.findOneOremById(oremId);
		job = orem.getJob();
		employer = job.getEmployer();
		principal = request.getPrincipal();

		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Orem> request, final Orem entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "text", "marker");
	}

	@Override
	public Orem findOne(final Request<Orem> request) {
		assert request != null;

		Orem result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneOremById(id);

		return result;
	}

}
