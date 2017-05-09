<#assign spring=JspTaglibs["http://www.springframework.org/tags"]>
<#macro mainTemplate title="MainTemplate">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Project</title>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600,700&amp;subset=cyrillic" rel="stylesheet">
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="/resources/css/animate.css" rel="stylesheet">

    <link href="/resources/css/plugins/select2/select2.min.css" rel="stylesheet">

    <link href="/resources/css/style.css" rel="stylesheet">
    <link href="/resources/css/custom-style.css" rel="stylesheet">

    <!-- Mainly scripts -->

    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <script src="/resources/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="/resources/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="/resources/js/inspinia.js"></script>
    <script src="/resources/js/plugins/pace/pace.min.js"></script>

    <!-- jQuery UI  -->
    <script src="/resources/js/plugins/jquery-ui/jquery-ui.min.js"></script>
    <script src="/resources/js/plugins/iCheck/icheck.min.js"></script>
    <@head/>
</head>
<body>
<div id="wrapper">
    <#include "fragments/navigation.ftl"/>

    <div id="page-wrapper" class="gray-bg">
        <#include "fragments/header.ftl"/>

        <!--CODE HERE-->
        <div class="wrapper wrapper-content">
            <@body/>
        </div>
        <#include "fragments/footer.ftl"/>
    </div>
</div>
</body>
</html>
</#macro>