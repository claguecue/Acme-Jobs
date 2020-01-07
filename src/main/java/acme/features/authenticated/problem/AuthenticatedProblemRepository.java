
package acme.features.authenticated.problem;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.jobs.Job;
import acme.entities.problems.Problem;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AuthenticatedProblemRepository extends AbstractRepository {

	@Query("select p from Problem p where p.id = ?1")
	Problem findOneProblemById(int id);

	@Query("select p from Problem p where p.job.id = ?1")
	Collection<Problem> findManyByJobId(int jobId);

	@Query("select j from Job j where j.id = ?1")
	Job findJobForThisProblem(int jobId);

	@Query("select p.job from Problem p where p.id = ?1")
	Job findJob(int problemId);

}
