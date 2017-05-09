<#include "../main.ftl">
<@mainTemplate/>
<#macro head>
<!-- FooTable -->
<link href="/resources/css/plugins/footable/footable.core.css" rel="stylesheet">

<!-- FooTable -->
<script src="/resources/js/plugins/footable/footable.all.min.js"></script>

<script src="/resources/js/elective-course.js"></script>

<link href="/resources/css/plugins/datapicker/datepicker3.css" rel="stylesheet">
<link href="/resources/css/plugins/slick/slick.css" rel="stylesheet">
<link href="/resources/css/plugins/slick/slick-theme.css" rel="stylesheet">
<link href="/resources/css/custon-datepicker.css" rel="stylesheet">


<!-- Data picker -->
<script src="/resources/js/plugins/datapicker/bootstrap-datepicker.js"></script>
<script src="/resources/js/plugins/datapicker/bootstrap-datepicker.ru.js"></script>
<script src="/resources/js/plugins/jquery.matchHeight/jquery.matchHeight.js" type="text/javascript"></script>

<script src="/resources/js/datepicker-options.js" type="text/javascript"></script>
<script src="/resources/js/ajax/schedule-group.js" type="text/javascript"></script>

<!-- slick carousel-->
<script src="/resources/js/plugins/slick/slick.min.js"></script>
<!-- Select2 -->
<script src="/resources/js/plugins/select2/select2.full.min.js"></script>

</#macro>
<#macro body>
<#--<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-8">
        <h2>Расписание по группам</h2>
    </div>
</div>-->
<!--CODE HERE-->

<div class="row">
    <div class="col-lg-6 col-lg-push-1 col-md-push-0">
        <div class="row row-eq-height">
            <div class="col-lg-6 col-xs-5">
                <div class="ibox column">
                    <div class="ibox-title hidden-xs">
                        <h4>Выберите группу</h4>
                    </div>
                    <div class="ibox-content">
                        <select class="select2 form-control" style="width:100px;" id="select-group">
                            <#list groups as group>
                                <option value="${group.groupNumber}">${group.groupNumber}</option>
                            </#list>
                        </select>
                        <button class="btn btn-primary" id="btn-today">Сегодня</button>
                    </div>
                </div>
            </div>
        <#--<div class="col-lg-6 col-xs-7">
            <div class="ibox column">
                <div class="ibox-title hidden-xs">
                    <h4>Обозначения</h4>
                </div>
                <div class="ibox-content">
                    <span class="label label-primary">Лекция</span>
                    <span class="label label-plain">Практика</span>
                </div>
            </div>
        </div>-->
            <div class="col-xs-12">
                <div class="ibox schedule">
                    <div class="ibox-title hidden-xs">
                        <h4>Расписание на день</h4>
                    </div>

                    <#--<div class="slick">-->
                        <div class="schedule">
                            <div class="ibox-content">
                                <h2><span class="day-of-week">Понедельник</span>, <br
                                        class="visible-xs"><span class="day">17</span> <span class="month">апреля</span></h2>
                                <table class="table table-bordered">
                                    <thead>
                                    <tr>
                                        <th>Начало</th>
                                        <th>Конец</th>
                                        <th>Предмет</th>
                                        <th><span class="hidden-xs">Аудитория</span><span class="visible-xs">Ауд.</span></th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <#--<tr>
                                        <td>13:35</td>
                                        <td>15:05</td>
                                        <td class="subject">Основы предпринимательства (<span>108</span>)</td>
                                        <td>Григорян К.А.</td>
                                    </tr>-->
                                    </tbody>
                                </table>
                            </div>
                        </div>

                    <#--</div>-->
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-4 col-xs-12 col-lg-push-1 col-md-push-0">
        <div class="ibox">
            <div class="ibox-title">
                <h4 class="pull-left">Календарь</h4>
                <div class="pull-right"><span class="label gray-bg table-bordered">четная</span><span
                        class="label white-bg table-bordered">нечетная</span></div>
            </div>
            <div class="ibox-content">
                <div id="datepicker"></div>
            </div>
        </div>
    </div>
</div>

</#macro>