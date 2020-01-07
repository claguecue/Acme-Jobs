
package acme.features.worker.application;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.applications.Application;
import acme.entities.problems.Problem;
import acme.entities.roles.Worker;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractShowService;

@Service
public class WorkerApplicationShowService implements AbstractShowService<Worker, Application> {

	@Autowired
	WorkerApplicationRepository repository;


	@Override
	public boolean authorise(final Request<Application> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<Application> request, final Application entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		Collection<Problem> problems = this.repository.findProblemsByJob(entity.getJob().getId());

		Boolean hasPassword = true;
		String password = this.repository.findPasswordOfApp(request.getModel().getInteger("id"));
		if (password == null || password.isEmpty()) {
			hasPassword = false;
		}

		Boolean hasCode = true;
		String code = this.repository.findCodeOfApp(request.getModel().getInteger("id"));
		if (code == null || code.isEmpty()) {
			hasCode = false;
		}

		request.unbind(entity, model, "referenceNumber", "creationMoment", "status");
		request.unbind(entity, model, "statement", "skills", "qualifications", "answer", "code", "password", "job.reference", "worker.userAccount.username", "employer.userAccount.username");
		model.setAttribute("listProblemEmpty", problems.isEmpty());
		model.setAttribute("noHasPassword", !hasPassword);
		model.setAttribute("hasCode", hasCode);
	}

	@Override
	public Application findOne(final Request<Application> request) {
		assert request != null;

		Application result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneApplicationById(id);

		return result;
	}

}
