class Game {
    // Private fields
    #id; #name; #year; #platform;

    //Constructor
    constructor(id, name, year, platform) {
        this.#id = id;
        this.#name = name;
        this.#year = year;
        this.#platform = platform;
    }

    //Getters
    get id() { return this.#id; }
    get name() { return this.#name; }
    get year() { return this.#year; }
    get platform() { return this.#platform; }
}

Vue.component("game-show", {
    props: ["game"],
    template: `
    <div>
    <h3>{{game.name}}</h3>
    <p>
    Id: {{game.id}}<br />
    Year: {{game.year}}<br />
    Price: {{game.price}}<br />
    Description: {{game.description}}<br />
    Platform: {{game.platform}}
    </p>
    <button @click="$emit('back')">Back</button>
    </div>
    `
    })

var vm = new Vue({
    el: "#gamesApp",
    data: {
        appName: "Games App",
        userName: "Group 3",
        games: [],
        selYear: "year",
        max: 4,
        show: false,
        previous: {},
        selGame: {},
        curPage: 0
    },
    methods: {
        listOfYears: function () {
            var list = [];
            this.games.forEach(function (g) {
                if (!(list.includes(g.year))) {
                    list.push(g.year);
                }
            });
            return list;
        },
        async getGames () {
            const response = await fetch("https://my-json-server.typicode.com/joseccampos/gamesLibrary/games");
            this.games = await response.json();
        },
        updateShow(g){
            this.previous = this.selGame;
            this.selGame = g

            if (this.previous.id == this.selGame.id && this.show==true){
                this.show=false
            }
            else if (this.previous.id == this.selGame.id && this.show==false || this.previous.id != this.selGame.id){
                this.show = true
            }
            else {
                this.show = false
            }
        }
    },
    created(){
        //this.games = [new Game(1,"LOL",1999,"PC"),
        //              new Game(2,"Albion ", 1999, "PC"),
        //              new Game(3,"GTA V",2015,"PS4"),
        //              new Game(4,"CSGO",2013,"PC")
        //             ]
        this.getGames()
    },
    computed:{
        years: function () {
            var list = [];
            this.games.forEach(function (g) {
                if (!(list.includes(g.year))) {
                    list.push(g.year);
                }
            });
            return list;
        },
        platforms: function() {
            var list = [];
            this.games.forEach(function (g) {
                if (!(list.includes(g.platform))) {
                    list.push(g.platform);
                }
            });
            return list;
        },
        gamesFiltered() {
            //return this.games.filter(g => g.year==this.selYear)
            return this.games
        },
        gamesPaginated() {
            let page = 1
            let current = page * this.max;
            let start = current - this.max;
            let pages = Math.ceil(this.games.length / this.max) + 1;
            let arr = []
            for(let i = 2; i <= pages; i++){
                arr.push([...this.games].slice(start,current))
                start = current 
                current = i * this.max
            }
            return arr
        }
    }
})