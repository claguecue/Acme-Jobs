<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>


<acme:list>
	<acme:list-column code="authenticated.problem.list.label.text" path="text" width="50%"/>
	<acme:list-column code="authenticated.problem.list.label.hint" path="hint" width="50%"/>
		
</acme:list>