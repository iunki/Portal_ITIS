<#include "../main.ftl">
<@mainTemplate/>
<#macro head>
<!-- FooTable -->
<link href="/resources/css/plugins/footable/footable.core.css" rel="stylesheet">

<!-- FooTable -->
<script src="/resources/js/plugins/footable/footable.all.min.js"></script>

<script src="/resources/js/ajax/labs.js"></script>

<link href="/resources/css/courses-labs.css" rel="stylesheet">
</#macro>
<#macro body>
<div class="wrapper my-wrapper-content ">
    <div class="row courses">
    <#--  <#if courses?has_content> -->
     <div class="col-lg-5 col-lg-push-1  lab">
         <div class="ibox float-e-margins">
             <div class="ibox-title">
                 <h5>Лаборатории ИТИС</h5>
                 <div class="ibox-tools">
                     <div class="input-group-btn">
                         <h5 class="course-title">Курс</h5>
                         <select class="course-select-sel " name="course" id="select-course">

                                 <option value="1">1</option>
                             <option value="2">2</option>
                             <option value="3">3</option>
                             <option value="4">4</option>

                         </select>
                     </div>
                 </div>
             </div>
             <div class="ibox-content">

                 <div class="row">
                     <div class="col-xs-12">
                         <table class="table table-bordered table-striped">
                             <thead>
                             <tr>
                                 <th>Курс </th>
                                 <th>Преподаватель</th>
                                 <th>Квота</th>

                             </tr>
                             </thead>

                             <tbody>
<#--  <#list courses as course>
                       <tr>
                           <td>${course.courseName}</td>
                           <td>${course.teacher.fullName}</td>
                           <td>quota?</td>

                       </tr>

</#list>-->
                          </tbody>
                      </table>
                  </div>
              </div>

          </div>

          <div class="text-right lab-button-div">

              <button type="button" class="btn  btn-primary lab-button"><strong>Записаться</strong></button>


              <button type="button" class="btn  btn-danger lab-button"><strong>Отменить запись</strong></button>

          </div>

      </div>
  </div>

  <div class="col-lg-5  col-lg-push-1 lab">
      <div class="row">
          <div class="col-lg-12">
              <div class="ibox float-e-margins">
                  <div class="ibox-title">
                      <h5>Ваша лаборатория</h5>
                  </div>

                  <div class="ibox-content">

                      <p> Вы отправили заявки в лабораторию Fujitsu <br> Ваша заявка находится на рассмотрениии.  </p>
                  </div>

              </div>
          </div>
      </div>

      <div class="row">
          <div class="col-lg-12">
              <div class="ibox float-e-margins">
                  <div class="ibox-title">
                      <h5>Описание лаборатории</h5>
                  </div>

                  <div class="ibox-content">

                      <p class="course-description">  </p>
                  </div>


                  <div class="text-right lab-button-div">
                      <button type="button" class="btn  btn-primary lab-button "><strong>Презентация</strong></button>
                  </div>
              </div>
          </div>

      </div>


  </div>
<#--
  <#else>
      <span>Курсы не найдены</span>
  </#if> -->
</div>
</div>


</#macro>













