<#assign spring=JspTaglibs["http://www.springframework.org/tags"]>
<#include "main.ftl">
<@mainTemplate />
<#macro head>
</#macro>
<#macro body>
<div class="col-xs-12 col-md-8 " id="welcome">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5><b>Добро пожаловать на портал ИТИС</b></h5>
        </div>
        <div class="ibox-content">
            <p>Высшая школа информационных технологий и информационных систем (ИТИС) - инновационный
                ИТ-факультет КФУ, основанный в 2011 году.</p>
            <p>
                ИТИС - это подготовка высококвалифицированных кадров, повышение квалификации и
                профессиональная переподготовка сотрудников предприятий в области информационных технологий,
                осуществление прикладных исследований для ИТ-индустрии.</p>
        </div>
    </div>
</div>
<div class="col-xs-12 col-md-7 " id="access">
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5><b>Доступ к разделам портала</b></h5>
        </div>
        <div class="ibox-content">
            <p> Гость имеет доступ к просмотру расписания и курсов по выбору/лабораторий.</p>
            <p>
                Для доступа к другим разделам портала Вам необходимо авторизироваться.</p>
        </div>
    </div>
</div>
</#macro>