<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textarea code="employer.problem.form.label.text" path="text"/>
	<acme:form-url code="employer.problem.form.label.hint" path="hint"/>
	
	
	<acme:form-submit test="${command == 'show' }" code="employer.problem.form.button.update" action="/employer/problem/update"/>
	<acme:form-submit test="${command == 'show' }" code="employer.problem.form.button.delete" action="/employer/problem/delete"/>
	<acme:form-submit test="${command == 'create' }" code="employer.problem.form.button.create" action="/employer/problem/create"/> 
	<acme:form-submit test="${command == 'update' }" code="employer.problem.form.button.update" action="/employer/problem/update"/>
	<acme:form-submit test="${command == 'delete' }" code="employer.problem.form.button.delete" action="/employer/problem/delete"/>
	
	<acme:form-return code="employer.problem.form.button.return"/>
</acme:form>


