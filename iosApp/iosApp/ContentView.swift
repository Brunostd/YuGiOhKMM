import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting()
    @State var listCard: [InfoModel] = [InfoModel(id: 0, name: "carregando...", type: "", desc: "", race: "", card_images: [CardImages(id: 0, image_url: "http://i.imgur.com/w5rkSIj.jpg", image_url_small: "")])]
    @State var action: Int? = 0
    @State var sendArgs: InfoModel = InfoModel(id: 0, name: "", type: "", desc: "", race: "", card_images: [CardImages(id: 0, image_url: "", image_url_small: "")])

    func load(){
        greet.getCard(){ result, error in
            if let result = result{
                self.listCard = result.data
            } else if let error = error{
                
            }
        }
    }
    
	var body: some View {
        NavigationView(content: {
            ZStack{
                NavigationLink(destination: SelectedCardView(args: $sendArgs),tag: 1, selection: $action, label: {EmptyView()})
                VStack{
                    Text("CARTAS YU-GI-OH").labelStyle(.titleOnly)
                    List(listCard, id: \.self){ value in
                        Button(action: {
                            self.action = 1
                            self.sendArgs = value
                        }, label: {
                            Text(value.name)
                        })
                    }
                    .onAppear{
                        load()
                    }
                }
            }
        })
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
