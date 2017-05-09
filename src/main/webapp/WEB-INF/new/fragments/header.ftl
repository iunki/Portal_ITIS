<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<div class="row border-bottom">
    <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i>
            </a>
            <img src="/resources/img/itis.png" alt="">
        </div>
        <ul class="nav navbar-top-links navbar-right">
        <@security.authorize access="isAuthenticated()">
            Hello <@security.authentication property="principal.username" />
            <li>
                <a href="/logout">
                    <i class="fa fa-sign-out"></i> Выйти
                </a>
            </li>
        </@security.authorize>

        <@security.authorize access="! isAuthenticated()">
            <li>
                <a href="/signin">
                    <i class="fa fa-sign-out"></i> Войти
                </a>
            </li>
            <li>
                <a href="/signup">
                    <i class="fa fa-sign-out"></i> Регистрация
                </a>
            </li>
        </@security.authorize>

        </ul>

    </nav>
</div>
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-8">
        <h2>Главная</h2>
    </div>
</div>