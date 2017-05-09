function setTableHeight() {
    $('.datepicker').css('height', $('.datepicker td').width() * 7);
    $('.table-condensed').css('height', $('.table-condensed td').width() * 7);
}

$(function () {
    $(".row-eq-height .column .ibox-content").matchHeight({
        byRow: false
    });
    $('.slick').slick({
        adaptiveHeight: true
    });
    var date = new Date();
    var today = new Date(date.getFullYear(), date.getMonth(), date.getDate());
    $('#datepicker').datepicker({
        inline: true,
        sideBySide: true,
        locale: 'ru',
        language: 'ru',
        daysOfWeekDisabled: [0],
        showTodayButton: true,
        setDate: today
    });
    $('#datepicker').datepicker()
        .on('changeDate', function (e) {
            rerender();
        });
    $('#datepicker').datepicker("update", today);
    $('#btn-today').on('click', function () {
        $('#datepicker').datepicker("update", today);
    });
    rerender();
    setTableHeight();
    $(window).resize(function () {
        setTableHeight();
    });
});