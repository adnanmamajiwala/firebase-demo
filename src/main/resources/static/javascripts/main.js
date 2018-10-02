(function (window, $) {
    "use strict";
    window.firebasedemo = window.firebasedemo || {};
    window.firebasedemo.behaviors = window.firebasedemo.behaviors || {};
    window.firebasedemo.bindBehaviors = function (container) {
        $(container).find("[data-behavior]").each(function () {
            var $element = $(this);
            var behaviors = $element.data("behavior").split(" ");
            $.each(behaviors, function (index, behavior) {
                var registeredBehaviors = window.firebasedemo.behaviors;
                if (behavior in registeredBehaviors) {
                    registeredBehaviors[behavior]($element);
                } else {
                    window.console.log("Undefined Behavior "+behavior);
                }
            });
        });
    };


})(window, jQuery);