
package acme.features.worker.application;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.jobs.Job;
import acme.entities.problems.Problem;
import acme.entities.roles.Worker;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface WorkerApplicationRepository extends AbstractRepository {

	@Query("select a from Application a where a.id = ?1")
	Application findOneApplicationById(int id);

	@Query("select a from Application a where a.worker.id = ?1")
	Collection<Application> findManyByWorkerId(int workerId);

	@Query("select j from Job j where j.deadline > current_timestamp() and j.finalMode = 'true'")
	Collection<Job> findActiveJob();

	@Query("select w from Worker w where w.id = ?1")
	Worker findOneWorkerById(int id);

	@Query("select j from Job j where j.id = ?1")
	Job findOneJobById(int id);

	@Query("select a from Application a where a.referenceNumber = ?1")
	Application findApplicationByReferenceNumber(String reference);

	@Query("select p from Problem p where p.job.id = ?1")
	Collection<Problem> findProblemsByJob(int jobId);

	@Query("select a.password from Application a where a.id = ?1")
	String findPasswordOfApp(int appId);

	@Query("select a.code from Application a where a.id = ?1")
	String findCodeOfApp(int appId);
}
