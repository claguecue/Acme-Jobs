//
//package acme.features.worker.application;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import acme.entities.applications.Application;
//import acme.entities.roles.Worker;
//import acme.framework.components.Errors;
//import acme.framework.components.HttpMethod;
//import acme.framework.components.Model;
//import acme.framework.components.Request;
//import acme.framework.components.Response;
//import acme.framework.entities.Principal;
//import acme.framework.helpers.PrincipalHelper;
//import acme.framework.services.AbstractUpdateService;
//
//@Service
//public class WorkerApplicationUpdateService implements AbstractUpdateService<Worker, Application> {
//
//	@Autowired
//	private WorkerApplicationRepository repository;
//
//
//	@Override
//	public boolean authorise(final Request<Application> request) {
//		assert request != null;
//		return true;
//	}
//
//	@Override
//	public void bind(final Request<Application> request, final Application entity, final Errors errors) {
//		assert request != null;
//		assert entity != null;
//		assert errors != null;
//
//		request.bind(entity, errors);
//	}
//
//	@Override
//	public void unbind(final Request<Application> request, final Application entity, final Model model) {
//		assert request != null;
//		assert entity != null;
//		assert model != null;
//
//		request.unbind(entity, model, includedProperties);
//
//	}
//
//	@Override
//	public Application findOne(final Request<Application> request) {
//		assert request != null;
//		Application result;
//		Principal principal;
//		int userAccountId;
//
//		principal = request.getPrincipal();
//		userAccountId = principal.getAccountId();
//
//		result = this.repository.findOneApplicationById(userAccountId);
//
//		return result;
//	}
//
//	@Override
//	public void validate(final Request<Application> request, final Application entity, final Errors errors) {
//		assert request != null;
//		assert entity != null;
//		assert errors != null;
//
//	}
//
//	@Override
//	public void update(final Request<Application> request, final Application entity) {
//
//		assert request != null;
//		assert entity != null;
//
//		this.repository.save(entity);
//	}
//
//	@Override
//	public void onSuccess(final Request<Application> request, final Response<Application> response) {
//		assert request != null;
//		assert response != null;
//
//		if (request.isMethod(HttpMethod.POST)) {
//			PrincipalHelper.handleUpdate();
//		}
//	}
//
//}
