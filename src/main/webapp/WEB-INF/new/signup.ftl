<#assign spring=JspTaglibs["http://www.springframework.org/tags"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#include "main.ftl">
<@mainTemplate />
<#macro head>

</#macro>
<#macro body>
<div class="loginColumns animated fadeInDown">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <div class="ibox-content">
                <@form.form commandName="signupForm" action='signup' method='post'  acceptCharset="UTF-8" cssClass="m-t">
                    <h1> Регистрация </h1>
                    <div class="form-group">
                        <label for="email">Email</label>
                        *<@form.errors path="email"/>
                        <@form.input id="email" path="email" cssClass="form-control"/>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        *<@form.errors path="password"/>
                        <@form.password id="password" path="password" cssClass="form-control"/>
                    </div>

                    <button type="submit" class="btn btn-primary block full-width m-b">Signup</button>

                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <p>Already have an account? <a href="signin">Sign In</a></p>
                        </div>
                    </div>
                </@form.form>
            </div>
        </div>
    </div>
</div>
</#macro>
