<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Café Loop</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
    				<ul class="nav navbar-nav navbar-right">
						<c:choose>
							<%-- Van bejelentkezett felhasználó --%>
							<c:when test="${sessionScope.loggedInCustomer != null}">
								<li><a href="${pageContext.request.contextPath}/customer-center/profile.jsp">
                                    <i class="fa fa-user"></i> <c:out value="${sessionScope.loggedInCustomer.name}"/>
                                </a></li>
								<li><a href="${pageContext.request.contextPath}/customer-center/subsciptions.jsp">Előfizetések</a></li>
								<li><a href="${pageContext.request.contextPath}/customer-center/new-subscription.jsp">Új
										előfizetés</a></li>

								<li><a
									href="${pageContext.request.contextPath}/customer-center/logout">Kijelentkezés</a></li>
							</c:when>

							<%-- Nincs bejelentkezett felhasználó --%>
							<c:otherwise>
								<li><a href="${pageContext.request.contextPath}/registration.jsp">Regisztráció</a></li>
								<li><a href="${pageContext.request.contextPath}/login.jsp">Bejelentkezés</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
        </div>
    </div>
</nav>