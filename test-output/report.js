$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/org/cuc/pom/feature/FreeCRM.feature");
formatter.feature({
  "line": 1,
  "name": "Logging into the FreeCRM page.",
  "description": "",
  "id": "logging-into-the-freecrm-page.",
  "keyword": "Feature"
});
formatter.before({
  "duration": 1160000,
  "status": "passed"
});
formatter.scenario({
  "line": 29,
  "name": "Adding two new Deals",
  "description": "",
  "id": "logging-into-the-freecrm-page.;adding-two-new-deals",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 28,
      "name": "@SystemTesting"
    },
    {
      "line": 28,
      "name": "@RegressionTesting"
    }
  ]
});
formatter.step({
  "line": 31,
  "name": "user navigates to FreeCRM webpage",
  "keyword": "Given "
});
formatter.step({
  "line": 32,
  "name": "user logs into the application",
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "user enters homepage",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "user clicks on Calendar link",
  "rows": [
    {
      "cells": [
        "hansolo",
        "version 1.0",
        "testing the list"
      ],
      "line": 35
    },
    {
      "cells": [
        "darth vader",
        "version 2.0",
        "Second Row"
      ],
      "line": 36
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "user enters event details",
  "rows": [
    {
      "cells": [
        "Title",
        "FromDate",
        "ToDate",
        "AssignedTo",
        "Reminder",
        "Contact"
      ],
      "line": 38
    },
    {
      "cells": [
        "Event 1",
        "29-12-2017 05:30",
        "29-12-2017 07:30",
        "bhargav sai",
        "30 Minutes",
        "test a"
      ],
      "line": 39
    },
    {
      "cells": [
        "Event Bhargav",
        "31-12-2017 05:30",
        "31-12-2017 08:30",
        "bhargav sai",
        "45 Minutes",
        "test b"
      ],
      "line": 40
    },
    {
      "cells": [
        "Event Han Solo",
        "28-12-2017 05:30",
        "28-12-2017 09:30",
        "bhargav sai",
        "4 Hours",
        "bruce"
      ],
      "line": 41
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "user closes the browser",
  "keyword": "And "
});
formatter.match({
  "location": "HomepageStepDef.user_navigates_to_FreeCRM_webpage()"
});
formatter.result({
  "duration": 13116211504,
  "status": "passed"
});
formatter.match({
  "location": "HomepageStepDef.user_logs_into_the_application()"
});
formatter.result({
  "duration": 18062739083,
  "status": "passed"
});
formatter.match({
  "location": "HomepageStepDef.user_enters_homepage()"
});
formatter.result({
  "duration": 95111069,
  "status": "passed"
});
formatter.match({
  "location": "HomepageStepDef.user_clicks_on_Calendar_link(DataTable)"
});
formatter.result({
  "duration": 5826375189,
  "status": "passed"
});
formatter.match({
  "location": "HomepageStepDef.user_enters_event_details(DataTable)"
});
formatter.result({
  "duration": 35220062124,
  "status": "passed"
});
formatter.match({
  "location": "HomepageStepDef.user_closes_the_browser()"
});
formatter.result({
  "duration": 965714682,
  "status": "passed"
});
formatter.after({
  "duration": 218222,
  "status": "passed"
});
});