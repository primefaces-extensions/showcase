/**
 * Showcase Library of JS functions.
 */
var Showcase = (function() {
   return {
      /**
       * https://stackoverflow.com/questions/9550760/hide-page-until-everything-is-loaded-advanced/9551066
       */
      displayPage : function() {
         $(document).ready(function() {
            // remove the z-index so some elements get rendered on top
            $("#layoutCenter").css("z-index", '');
            
            // show the HTML pane after everything has been asjusted
            // https://stackoverflow.com/questions/9550760/hide-page-until-everything-is-loaded-advanced/9551066
            document.getElementsByTagName("html")[0].style.visibility = "visible";
         });
      },
      
      selectComponentLink: function(link) {
         $("#componentList").find(".ui-state-active").removeClass("ui-state-active");
         if (link) {
             $(link).addClass("ui-state-active");
         }
      }, 
      
      selectUseCaseLink : function(link) {
         $("#useCaseList").find(".ui-state-active").removeClass("ui-state-active");
         if (link) {
             $(link).addClass("ui-state-active");
         }
      }
   };
})();
