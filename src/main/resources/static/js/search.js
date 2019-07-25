$("#submissionBtn").click(function()
    {
        // Get form parameters
        values = $("form").serialize();
        // Redirect to url
        window.location.href = "http://localhost:8080/query?" + values;
    }
);



$(document).ready(function() {
    var mechanicsList = "Acting, Action / Movement Programming, Action Point Allowance System, Area Control / Area Influence, Area Enclosure, Area Movement, Area-Impulse, Auction/Bidding, Betting/Wagering, Campaign / Battle Card Driven, Card Drafting, Chit-Pull System, Commodity Speculation, Cooperative Play, Crayon Rail System, Deck / Pool Building, Dice Rolling, Grid Movement, Hand Management, Hex-and-Counter, Hidden Traitor, Line Drawing, Memory, Modular Board, Paper-and-Pencil, Partnerships, Pattern Building, Pattern Recognition, Pick-up and Deliver, Player Elimination, Point to Point Movement, Press Your Luck, Rock-Paper-Scissors, Role Playing, Roll / Spin and Move, Rondel, Route/Network Building, Secret Unit Deployment, Set Collection, Simulation, Simultaneous Action Selection, Singing, Stock Holding, Storytelling, Take That, Tile Placement, Time Track, Trading, Trick-taking, Variable Phase Order, Variable Player Powers, Voting, Worker Placement"

    var categoriesList = "Abstract Strategy, Action / Dexterity, Adventure, Age of Reason, American Civil War, American Indian Wars, American Revolutionary War, American West, Ancient, Animals, Arabian, Aviation / Flight, Bluffing, Book, Card Game, Childrens Game, City Building, Civil War, Civilization, Collectible Components, Comic Book / Strip, Deduction, Dice, Economic, Educational, Electronic, Environmental, Expansion for Base-game, Exploration, Fan Expansion, Fantasy, Farming, Fighting, Game System, Horror, Humor, Industry / Manufacturing, Korean War, Mafia, Math, Mature / Adult, Maze, Medical, Medieval, Memory, Miniatures, Modern Warfare, Movies / TV / Radio theme, Murder/Mystery, Music, Mythology, Napoleonic, Nautical, Negotiation, Novel-based, Number, Party Game, Pike and Shot, Pirates, Political, Post-Napoleonic, Prehistoric, Print & Play, Puzzle, Racing, Real-time, Religious, Renaissance, Science Fiction, Space Exploration, Spies/Secret Agents, Sports, Territory Building, Trains, Transportation, Travel, Trivia, Video Game Theme, Vietnam War, Wargame, Word Game, World War I, World War II, Zombies"

    // Generate mechanics checkboxes
    var mechanics = mechanicsList.split(',');
    var addedMechanicsRow = ''
    for (var i = 0; i < mechanics.length; i++) {
        addedMechanicsRow += '<div class="form-check form-check-inline"><input class="form-check-input" type="checkbox" value=' +
        mechanics[i] + '><label class="form-check-label" for=' + mechanics[i] + '>' + mechanics[i] +'</label></div>';
        console.log(i);
    }
    $('#mechanics_grid').html(addedMechanicsRow);


    // Generate category checkboxess
    var categories = categoriesList.split(',');
    var addedCategoriesRow = ''
    for (var i = 0; i < mechanics.length; i++) {
        addedCategoriesRow += '<div class="form-check form-check-inline"><input class="form-check-input" type="checkbox" value=' +
        categories[i] + '><label class="form-check-label" for=' + categories[i] + '>' + categories[i] +'</label></div>';
    }
    $('#categories_grid').html(addedCategoriesRow);
 });