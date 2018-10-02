(function (window) {
    "use strict";
    window.firebasedemo = window.firebasedemo || {};
    window.firebasedemo.behaviors = window.firebasedemo.behaviors || {};

    window.firebasedemo.behaviors.postData = function ($element) {
        var formId = $element.data("form-id");
        var $form = $element.parents().find("#" + formId);

        function submitForm() {
            $form.submit();
        }

        $element.on("click", submitForm);
    }

})(window);