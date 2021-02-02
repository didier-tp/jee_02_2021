<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>
    <h:messages />
    <h:form>
       ht : <h:inputText value="#{tvaMBean.ht}"/> <br/>
       tauxTva : <h:inputText value="#{tvaMBean.tauxTva}"/> <br/>
       <h:commandButton value="calculer Tva" action="#{tvaMBean.calculerTva}" />
    </h:form>
    tva = <h:inputText value="#{tvaMBean.tva}"/> <br/>
    ttc = <h:inputText value="#{tvaMBean.ttc}"/> <br/>
</f:view>
</body>
</html>