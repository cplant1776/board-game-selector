$("#submissionBtn").click(function()
    {
        // Get form parameters
        values = $("form").serialize();
        // Redirect to url
        window.location.href = "/query?" + values;
    }
);

$("#addBtn").click(function()
    {
        window.location.href = "/add";
    }
);


function addSlider(min, max, minSelect, sliderId, maxSelect, isInverted) {

    var html5Slider = document.getElementById(sliderId);
    noUiSlider.create(html5Slider, {
        start: [min, max],
        connect: true,
        range: {
            'min': min,
            'max': max
        }
    });


    var minNumber = document.getElementById(minSelect);
    var maxNumber = document.getElementById(maxSelect);

    html5Slider.noUiSlider.on('update', function (values, handle) {
    
        var value = values[handle];
    
        if (handle) {
            maxNumber.value = Math.round(value);
        } else {
            minNumber.value = Math.round(value);
        }
    });

    maxNumber.addEventListener('change', function () {
        if (isInverted)
            html5Slider.noUiSlider.set([Math.round(this.value), null]);
        else
            html5Slider.noUiSlider.set([null, Math.round(this.value)]);
    });
    minNumber.addEventListener('change', function () {
        if (isInverted)
            html5Slider.noUiSlider.set([null, Math.round(this.value)]);
        else
            html5Slider.noUiSlider.set([Math.round(this.value), null]);
    });
    
    


    console.log(minNumber);
    console.log(html5Slider);
    console.log(maxNumber);

};




$(document).ready(function() {


    addSlider(1, 5500, 'rankMin', 'rankSlider', 'rankMax', false);
    addSlider(1, 100, 'playersMin', 'playersSlider', 'playersMax', false);
    addSlider(0, 2019, 'yearMin', 'yearSlider', 'yearMax', false);
    addSlider(0, 6000, 'avgPlayTimeMin', 'avgPlayTimeSlider', 'avgPlayTimeMax', false);
    addSlider(0, 6000, 'minPlayTimeMin', 'minPlayTimeSlider', 'minPlayTimeMax', false);
    addSlider(0, 6000, 'maxPlayTimeMin', 'maxPlayTimeSlider', 'maxPlayTimeMax', false);
    addSlider(0, 100000, 'votesMin', 'votesSlider', 'votesMax', false);
    addSlider(0, 100, 'ageMin', 'ageSlider', 'ageMax', false);
    addSlider(0, 6000, 'fansMin', 'fansSlider', 'fansMax', false);
    
            


    // var mechanicsList = "Acting, Action / Movement Programming, Action Point Allowance System, Area Control / Area Influence, Area Enclosure, Area Movement, Area-Impulse, Auction/Bidding, Betting/Wagering, Campaign / Battle Card Driven, Card Drafting, Chit-Pull System, Commodity Speculation, Cooperative Play, Crayon Rail System, Deck / Pool Building, Dice Rolling, Grid Movement, Hand Management, Hex-and-Counter, Hidden Traitor, Line Drawing, Memory, Modular Board, Paper-and-Pencil, Partnerships, Pattern Building, Pattern Recognition, Pick-up and Deliver, Player Elimination, Point to Point Movement, Press Your Luck, Rock-Paper-Scissors, Role Playing, Roll / Spin and Move, Rondel, Route/Network Building, Secret Unit Deployment, Set Collection, Simulation, Simultaneous Action Selection, Singing, Stock Holding, Storytelling, Take That, Tile Placement, Time Track, Trading, Trick-taking, Variable Phase Order, Variable Player Powers, Voting, Worker Placement"

    // var categoriesList = "Abstract Strategy, Action / Dexterity, Adventure, Age of Reason, American Civil War, American Indian Wars, American Revolutionary War, American West, Ancient, Animals, Arabian, Aviation / Flight, Bluffing, Book, Card Game, Childrens Game, City Building, Civil War, Civilization, Collectible Components, Comic Book / Strip, Deduction, Dice, Economic, Educational, Electronic, Environmental, Expansion for Base-game, Exploration, Fan Expansion, Fantasy, Farming, Fighting, Game System, Horror, Humor, Industry / Manufacturing, Korean War, Mafia, Math, Mature / Adult, Maze, Medical, Medieval, Memory, Miniatures, Modern Warfare, Movies / TV / Radio theme, Murder/Mystery, Music, Mythology, Napoleonic, Nautical, Negotiation, Novel-based, Number, Party Game, Pike and Shot, Pirates, Political, Post-Napoleonic, Prehistoric, Print & Play, Puzzle, Racing, Real-time, Religious, Renaissance, Science Fiction, Space Exploration, Spies/Secret Agents, Sports, Territory Building, Trains, Transportation, Travel, Trivia, Video Game Theme, Vietnam War, Wargame, Word Game, World War I, World War II, Zombies"

    // // Generate mechanics checkboxes
    // var mechanics = mechanicsList.split(',');
    // var addedMechanicsRow = ''
    // for (var i = 0; i < mechanics.length; i++) {
    //     addedMechanicsRow += '<div class="form-check form-check-inline"><input class="form-check-input" type="checkbox" value=' +
    //     mechanics[i] + '><label class="form-check-label" for=' + mechanics[i] + '>' + mechanics[i] +'</label></div>';
    //     console.log(i);
    // }
    // $('#mechanics_grid').html(addedMechanicsRow);


    // // Generate category checkboxess
    // var categories = categoriesList.split(',');
    // var addedCategoriesRow = ''
    // for (var i = 0; i < mechanics.length; i++) {
    //     addedCategoriesRow += '<div class="form-check form-check-inline"><input class="form-check-input" type="checkbox" value=' +
    //     categories[i] + '><label class="form-check-label" for=' + categories[i] + '>' + categories[i] +'</label></div>';
    // }
    // $('#categories_grid').html(addedCategoriesRow);
 });